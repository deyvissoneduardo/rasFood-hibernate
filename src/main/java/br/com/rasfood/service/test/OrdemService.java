package br.com.rasfood.service.test;

import br.com.rasfood.dao.OrdemDao;
import br.com.rasfood.utils.CargaDadosUtils;
import br.com.rasfood.utils.JPAUtils;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtils.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDadosUtils.cadastrarCategoria(entityManager);
        CargaDadosUtils.cadastrarCategoria(entityManager);
        CargaDadosUtils.cadastrarClientes(entityManager);
        CargaDadosUtils.cadastrarOrdensClientes(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        ordemDao.itensMaisVendidos().forEach(item->System.out.println("Item: "+item[0]+"\t-\tQuantidade: "+item[1]));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
