package Testes;


import br.com.rocha.calcados.testes.Pedido;
import br.com.rocha.calcados.testes.Item;
import br.com.rocha.calcados.testes.Produto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author DaRocha
 */
public class Testar {
    
    @Test
    //@Ignore
    public void consultarClientes(){
        
        Produto p_1 = new Produto();
        p_1.setCodigo(1);
        p_1.setNome("Geladeira");
        
        Produto p_2 = new Produto();
        p_2.setCodigo(2);
        p_2.setNome("Televisao");
        
        Pedido p = new Pedido();
        p.setCodigo(1);
        p.setData("01/02/2012");
        
        Item i = new Item();
        i.setCodigo(1);
        i.setProduto(p_1);
        i.setQuantidade("1");
        i.setPedido(p);
        
        Item it = new Item();
        it.setCodigo(2);
        it.setProduto(p_2);
        it.setQuantidade("4");
        it.setPedido(p);
        
        
        
        p.getItens().add(i);
        p.getItens().add(it);
        
        
        //System.out.println(p);


        Gson g = new Gson();
        
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        
        final String representacionBonita = prettyGson.toJson(p);
        System.out.println(representacionBonita);
        
    
    }
}
