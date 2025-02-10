package br.com.rasfood.dao;

import br.com.rasfood.entity.Cardapio;

import javax.persistence.EntityManager;
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
//        String sql = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery("from Cardapio", Cardapio.class).getResultList();
    }

}
