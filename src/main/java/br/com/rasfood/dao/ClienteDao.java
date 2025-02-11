package br.com.rasfood.dao;

import br.com.rasfood.entity.Cardapio;
import br.com.rasfood.entity.Categoria;
import br.com.rasfood.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class ClienteDao {

    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    public void excluir(Cliente cliente) {
        this.entityManager.remove(cliente);
    }

    public void alterar(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    public Cliente buscarPorId(final Integer id)
    {
        return this.entityManager.find(Cliente.class, id);
    }


    public List<Cliente> listar() {
        try {
            return this.entityManager
                    .createQuery("from Cliente", Cliente.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Cliente  buscarPorNome(final String nome) {
        try{
            return this.entityManager
                    .createQuery("SELECT c FROM Cliente c WHERE UPPER(c.nome) = UPPER(:nome) ", Cliente .class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        }catch (Exception e){
            return null;
        }
    }
}
