package br.com.rasfood.dao;


import br.com.rasfood.entity.Categoria;
import br.com.rasfood.entity.Endereco;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDao {

    private EntityManager entityManager;

    public EnderecoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(final Endereco endereco) {
        this.entityManager.persist(endereco);
    }

    public Categoria consultarPorId(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Endereco> consultarTodos() {
        String jpql = "SELECT e FROM Endereco e";
        return this.entityManager.createQuery(jpql,Endereco.class).getResultList();
    }

    public void atualizar(final Endereco endereco){
        this.entityManager.merge(endereco);
    }

    public void excluir(final Endereco endereco){
        this.entityManager.remove(endereco);
    }
}