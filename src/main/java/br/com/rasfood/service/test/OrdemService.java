package br.com.rasfood.service.test;

import br.com.rasfood.dao.CardapioDao;
import br.com.rasfood.dao.ClienteDao;
import br.com.rasfood.dao.OrdemDao;
import br.com.rasfood.entity.Cliente;
import br.com.rasfood.entity.Endereco;
import br.com.rasfood.entity.Ordem;
import br.com.rasfood.entity.OrdensCardapio;
import br.com.rasfood.utils.CargaDadosUtils;
import br.com.rasfood.utils.JPAUtils;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtils.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDadosUtils.cadastrarCategoria(entityManager);
        CargaDadosUtils.cadastrarProduto(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Endereco endereco = new Endereco("00111222", "sem teto", "sem rua", "cidade", "DF");
        Cliente teste01 = new Cliente("00011122233", "Teste");
        teste01.addEndereco(endereco);
        Ordem ordem01 = new Ordem(teste01);
        ordem01.addOrdensCardapio(new OrdensCardapio(cardapioDao.buscarPorId(1), 2));
        ordem01.addOrdensCardapio(new OrdensCardapio(cardapioDao.buscarPorId(2), 3));

        clienteDao.salvar(teste01);
        ordemDao.salvar(ordem01);

        System.out.println(ordem01);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
