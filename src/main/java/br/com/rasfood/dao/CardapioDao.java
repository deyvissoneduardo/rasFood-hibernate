package br.com.rasfood.dao;

import br.com.rasfood.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(final Cardapio prato) {
        this.entityManager.persist(prato);
    }

    public Cardapio buscarPorId(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public void excluir(final Cardapio prato) {
        this.entityManager.remove(prato);
    }

    public void editar(final Cardapio prato) {
        this.entityManager.merge(prato);
    }

    public List<Cardapio> listar() {
        try {
            return this.entityManager
                    .createQuery("SELECT c FROM Cardapio c", Cardapio.class)
                    .getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cardapio> buscarPorValor(final BigDecimal valor) {
       try {
           return this.entityManager
                   .createQuery("SELECT c FROM Cardapio c WHERE c.valor = :valor", Cardapio.class)
                   .setParameter("valor", valor)
                   .getResultList();
       } catch (Exception e) {
           return Collections.emptyList();
       }
    }


    public Cardapio buscarPorNome(final String nome) {
      try{
          return this.entityManager
                  .createQuery("SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome) ", Cardapio.class)
                  .setParameter("nome", nome)
                  .getSingleResult();
      }catch (Exception e){
          return null;
      }
    }
}
