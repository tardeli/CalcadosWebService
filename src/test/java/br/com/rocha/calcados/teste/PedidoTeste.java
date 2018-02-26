package br.com.rocha.calcados.teste;

import br.com.rocha.calcados.dao.ClienteDao;
import br.com.rocha.calcados.dao.PedidoDao;
import br.com.rocha.calcados.dao.ProdutoDao;
import br.com.rocha.calcados.modelo.Cliente;
import br.com.rocha.calcados.modelo.ItemPedido;
import br.com.rocha.calcados.modelo.Pedido;
import br.com.rocha.calcados.modelo.Produto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author DaRocha
 */
public class PedidoTeste {

    PedidoDao pedidoDao = new PedidoDao();
    Pedido pedido = new Pedido();
    String json;
    ObjectMapper mapper;

    @Test
    @Ignore
    public void cadastrar() throws JsonProcessingException {

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.buscarObjeto(1L);

        ItemPedido itemPedido_1 = new ItemPedido();

        ProdutoDao produtoDao = new ProdutoDao();
        Produto p1 = produtoDao.buscarObjeto(2L);

        itemPedido_1.setPedido(pedido);
        itemPedido_1.setProduto(p1);
        itemPedido_1.setQuantidade(1);
        itemPedido_1.setTamanho("3");
        itemPedido_1.setTotal(p1.getPrecoCusto() * itemPedido_1.getQuantidade());
        
        ItemPedido itemPedido_2 = new ItemPedido();
        Produto p2 = produtoDao.buscarObjeto(1L);

        itemPedido_2.setPedido(pedido);
        itemPedido_2.setProduto(p2);
        itemPedido_2.setQuantidade(6);
        itemPedido_2.setTamanho("1,6");
        itemPedido_2.setTotal(p2.getPrecoCusto() * itemPedido_2.getQuantidade());
        
        
        pedido.getItens().add(itemPedido_1);
        pedido.getItens().add(itemPedido_2);

        pedido.setCliente(cliente);
        pedido.setData(new Date());
        pedido.setDesconto(60.00);
        pedido.setTotal(167.00 - pedido.getDesconto());
        
        pedidoDao.salvar(pedido);
        
        mapper = new ObjectMapper();

        // If we want to print the json formatted
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Getting json as String
        json = mapper.writeValueAsString(pedido);
        System.out.println(json);
        

    }
    
    
     
    @Test
    @Ignore
    public void lerPedido_comGson() {
        //tem que mapear com @Expose (serialize = true)
        List<Pedido> pedidos = new ArrayList<>();
        pedidos = pedidoDao.listaPedido_semRepetir();

        //listar normal
        //System.out.println(pedido);
        //listar gson
        //Gson g = new Gson();
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        final String representacionBonita = prettyGson.toJson(pedidos);
        System.out.println(representacionBonita);

        //System.out.println(pedido.gerarObjeto_Gson());
//        List<Pedido> pedidos = new ArrayList<>();
//        pedidos = pedidoDao.listarObjetos();
//        System.out.println(pedido.gerarListaObjeto_Gson(pedidos));
    }

    @Test
    @Ignore
    public void gerarGson_comJackson() throws JsonProcessingException {
        Pedido pedido = new Pedido();
        pedido = pedidoDao.buscarObjeto(2L);

        mapper = new ObjectMapper();

        // If we want to print the json formatted
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Getting json as String
        json = mapper.writeValueAsString(pedido);
        System.out.println(json);
    }

    @Test
    @Ignore
    public void converterGson_comJackson() throws IOException{
        Pedido pedido = new Pedido();
        pedido = pedidoDao.buscarObjeto(2L);

        mapper = new ObjectMapper();

        // If we want to print the json formatted
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Getting json as String
        json = mapper.writeValueAsString(pedido);
        //System.out.println(json);
                
        Pedido retorno = new Pedido();
        retorno = mapper.readValue(json, Pedido.class); // Ooops
        
        System.out.println(retorno);
    }

    
    @Test
    @Ignore
    public void tranformarJson() {
        Pedido pedido = pedidoDao.buscarObjeto(1L);

        Gson gson = new Gson();

        String valor = gson.toJson(pedido);

        System.out.println(valor);

    }

}
