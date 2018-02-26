package br.com.rocha.calcados.teste;

import br.com.rocha.calcados.dao.ProdutoDao;
import br.com.rocha.calcados.modelo.Produto;
import com.google.gson.Gson;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author DaRocha
 */
public class ProdutoTeste {
    @Test
    @Ignore
    public void listar(){
        Produto produto = new Produto();
        ProdutoDao dao = new ProdutoDao();
        List<Produto> produtos = dao.listarObjetos();
        
        System.out.println(produtos);
        
    }
    
    @Test
    public void json(){
        Produto produto = new Produto();
        ProdutoDao dao = new ProdutoDao();
        List<Produto> produtos = dao.listarObjetos();
        
        Gson g = new Gson();
        
        
        System.out.println(g.toJson(produtos));
        
    }
}
