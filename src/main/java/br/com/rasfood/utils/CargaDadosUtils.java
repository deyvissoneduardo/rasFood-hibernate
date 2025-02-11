package br.com.rasfood.utils;

import br.com.rasfood.dao.CardapioDao;
import br.com.rasfood.dao.CategoriaDao;
import br.com.rasfood.entity.Cardapio;
import br.com.rasfood.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDadosUtils {

    private CargaDadosUtils() {}

    static public void cadastrarCategoria(EntityManager entityManager) {
        Categoria pratoPrincipal = new Categoria("Prato Principal");
        Categoria entrada = new Categoria("Entrada");
        Categoria sobremesa = new Categoria("Sobremesa");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.salvar(entrada);
        entityManager.flush();
        categoriaDao.salvar(pratoPrincipal);
        entityManager.flush();
        categoriaDao.salvar(sobremesa);
        entityManager.flush();
        entityManager.clear();

    }

    static public void cadastrarProduto(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        List<Categoria> categorias = categoriaDao.listar();
        Cardapio moqueca = new Cardapio("Moqueca", "Peixe branco, banana da terra, arroz e farofa",
                true, BigDecimal.valueOf(95.00), categorias.get(2));
        Cardapio spaguetti = new Cardapio("Spaguetti", "Spagatti ao molho de parmesão e cogumelos",
                true, BigDecimal.valueOf(68.00), categorias.get(2));
        Cardapio bife = new Cardapio("Bife", "Bife acebolado com arroz branco, farofa e batata frita",
                true, BigDecimal.valueOf(59.00), categorias.get(2));
        Cardapio cordeiro = new Cardapio("Cordeiro", "Cordeiro com risoto de funghi",
                true, BigDecimal.valueOf(88.00), categorias.get(2));
        Cardapio burrata = new Cardapio("Burrata", "Tomates queimados, rúcula e torrada",
                true, BigDecimal.valueOf(15.00), categorias.get(0));
        Cardapio bruschetta = new Cardapio("Bruschetta", "Tomate, mucarela e manjericao",
                true, BigDecimal.valueOf(20.00), categorias.get(0));
        Cardapio scappeta = new Cardapio("Scappeta", "Ragu de linguica e torradinhas",
                true, BigDecimal.valueOf(25.00), categorias.get(0));
        Cardapio caprese = new Cardapio("Caprese", "Mini rucula e mucarela",
                true, BigDecimal.valueOf(47.00), categorias.get(1));
        Cardapio caesar = new Cardapio("Caesar", "Salada de franco com molho ceasar",
                true, BigDecimal.valueOf(40.00), categorias.get(1));
        Cardapio chevre = new Cardapio("Chevre", "Mix de folhas, mostarda e mel",
                true, BigDecimal.valueOf(59.00), categorias.get(1));

        cardapioDao.salvar(moqueca);
        cardapioDao.salvar(spaguetti);
        cardapioDao.salvar(bife);
        cardapioDao.salvar(cordeiro);
        cardapioDao.salvar(burrata);
        cardapioDao.salvar(bruschetta);
        cardapioDao.salvar(scappeta);
        cardapioDao.salvar(caprese);
        cardapioDao.salvar(caesar);
        cardapioDao.salvar(chevre);
        entityManager.flush();
        entityManager.clear();
    }
}
