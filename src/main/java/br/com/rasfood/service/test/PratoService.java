package br.com.rasfood.service.test;

import br.com.rasfood.dao.PratoDao;
import br.com.rasfood.entity.Prato;
import br.com.rasfood.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {
        Prato risoto = new Prato();
        risoto.setNome("Risoto");
        risoto.setDescricao("Risoto descricao");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.55));

        Prato macarrao = new Prato();
        macarrao.setNome("macarrao");
        macarrao.setDescricao("macarrao descricao");
        macarrao.setDisponivel(true);
        macarrao.setValor(BigDecimal.valueOf(50.00));

        EntityManager entityManager = JPAUtils.getEntityManagerRasFood();
        PratoDao pratoDao = new PratoDao(entityManager);
        entityManager.getTransaction().begin();
        pratoDao.salvar(risoto);
        entityManager.flush();
        pratoDao.salvar(macarrao);
        entityManager.flush();

        System.out.println("Consulta prato" + pratoDao.buscarPorId(2));

//        pratoDao.excluir(risoto);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        entityManager.clear();
        macarrao.setValor(BigDecimal.valueOf(15.00));
        pratoDao.editar(macarrao);
        System.out.println("Consulta prato" + pratoDao.buscarPorId(2));

    }
}
