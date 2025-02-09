package br.com.rasfood.service.test;

import br.com.rasfood.dao.PratoDao;
import br.com.rasfood.entity.Prato;
import br.com.rasfood.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {
        Prato risoto = new Prato();
        risoto.setNome("Risoto");
        risoto.setDescricao("Risoto descricao");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.55));

        EntityManager entityManager = JPAUtils.getEntityManagerRasFood();
        PratoDao pratoDao = new PratoDao(entityManager);
        entityManager.getTransaction().begin();
        pratoDao.salvar(risoto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
