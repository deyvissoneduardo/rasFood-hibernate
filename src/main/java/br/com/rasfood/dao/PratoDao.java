package br.com.rasfood.dao;

import br.com.rasfood.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDao {

    private EntityManager entityManager;

    public PratoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(final Prato prato) {
        this.entityManager.persist(prato);
        System.out.println("Salvo com sucesso! " + prato);
    }

    public Prato buscarPorId(final Integer id) {
        return this.entityManager.find(Prato.class, id);
    }

    public void excluir(final Prato prato) {
        this.entityManager.remove(prato);
    }

    public void editar(final Prato prato) {
        this.entityManager.merge(prato);
    }
}
