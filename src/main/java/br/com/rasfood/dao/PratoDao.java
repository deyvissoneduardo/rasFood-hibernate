package br.com.rasfood.dao;

import br.com.rasfood.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDao {

    private EntityManager entityManager;

    public PratoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Prato prato) {
        this.entityManager.persist(prato);
        System.out.println("Salvo com sucesso! " + prato);
    }
}
