package br.com.rasfood.dao;

import br.com.rasfood.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public void excluir(Categoria categoria) {
        this.entityManager.remove(categoria);
    }

    public Categoria buscarPorId(Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public void editar(Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public List<Categoria> listar() {
        return this.entityManager.createQuery("from Categoria", Categoria.class).getResultList();
    }
}
