package br.com.rasfood.dao;

import br.com.rasfood.entity.Cliente;
import br.com.rasfood.entity.Ordem;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class OrdemDao {

    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Ordem ordem) {
        this.entityManager.persist(ordem);
    }

    public void excluir(Ordem ordem) {
        this.entityManager.remove(ordem);
    }

    public void alterar(Ordem ordem) {
        this.entityManager.merge(ordem);
    }

    public Ordem buscarPorId(final Integer id)
    {
        return this.entityManager.find(Ordem.class, id);
    }


    public List<Ordem> listar() {
        try {
            return this.entityManager
                    .createQuery("from Ordem", Ordem.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Ordem  buscarPorNome(final String nome) {
        try{
            return this.entityManager
                    .createQuery("SELECT c FROM Ordem c WHERE UPPER(c.cliente) = UPPER(:nome) ", Ordem .class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        }catch (Exception e){
            return null;
        }
    }
}
