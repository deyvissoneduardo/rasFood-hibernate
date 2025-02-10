package br.com.rasfood.service.test;

import br.com.rasfood.dao.CardapioDao;
import br.com.rasfood.dao.CategoriaDao;
import br.com.rasfood.entity.Cardapio;
import br.com.rasfood.entity.Categoria;
import br.com.rasfood.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtils.getEntityManagerRasFood();
        saveProduto(entityManager, saveCategoria(entityManager));
    }

    private static Categoria saveCategoria(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria categoria = new Categoria("Prato Principal");

        entityManager.getTransaction().begin();
        categoriaDao.salvar(categoria);
        entityManager.getTransaction().commit();
        entityManager.clear();

        return categoria;
    }

    private static void saveProduto(EntityManager entityManager, Categoria categoria) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto");
        risoto.setDescricao("Risoto descricao");
        risoto.setDisponivel(true);
        risoto.setCategoria(categoria);
        risoto.setValor(BigDecimal.valueOf(88.55));

        Cardapio macarrao = new Cardapio();
        macarrao.setNome("macarrao");
        macarrao.setDescricao("macarrao descricao");
        macarrao.setDisponivel(true);
        macarrao.setCategoria(categoria);
        macarrao.setValor(BigDecimal.valueOf(50.00));

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        cardapioDao.salvar(risoto);
        entityManager.flush();
        cardapioDao.salvar(macarrao);
        entityManager.flush();

//        System.out.println("Consulta prato" + cardapioDao.buscarPorId(1));
//        System.out.println("Consulta prato" + cardapioDao.buscarPorId(2));
        cardapioDao.listar().forEach(item -> System.out.println("Consulta " + item));

        entityManager.close();
    }
}
