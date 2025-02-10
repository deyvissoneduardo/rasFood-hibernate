package br.com.rasfood.service.test;

import br.com.rasfood.dao.CardapioDao;
import br.com.rasfood.utils.CargaDadosUtils;
import br.com.rasfood.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtils.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDadosUtils.cadastrarCategoria(entityManager);
        CargaDadosUtils.cadastrarProduto(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println(cardapioDao.buscarPorValor(BigDecimal.valueOf(59.00)));
        entityManager.close();
    }
}
