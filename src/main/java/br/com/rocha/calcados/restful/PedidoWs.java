package br.com.rocha.calcados.restful;

import br.com.rocha.calcados.dao.PedidoDao;
import br.com.rocha.calcados.modelo.Pedido;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DaRocha
 */
@Path("pedido")
public class PedidoWs {

    public PedidoWs() {
    }

    Pedido pedido = new Pedido();
    PedidoDao pedidoDao = new PedidoDao();
    ObjectMapper mapper;
    String json;

    //http://127.0.0.1:8080/CalcadosWebService/rest/pedido/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() throws JsonProcessingException {

        List<Pedido> pedidos = new ArrayList<>();
        pedidos = pedidoDao.listaPedido_semRepetir();

        mapper = new ObjectMapper();
        // If we want to print the json formatted
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Getting json as String
        return  json = mapper.writeValueAsString(pedidos);
    }

    //http://127.0.0.1:8080/CalcadosWebService/rest/pedido
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{codigo}")
    public String buscarPorId(@PathParam("codigo") Long codigo) throws JsonProcessingException {
        mapper = new ObjectMapper();
        // If we want to print the json formatted
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Pedido pedido = pedidoDao.buscarObjeto(codigo);
        
        return json = mapper.writeValueAsString(pedido);
    }

//http://127.0.0.1:8080/CalcadosWebService/rest/pedido
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String incluir(String json) throws IOException {
        mapper = new ObjectMapper();
        // If we want to print the json formatted
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
                
        Pedido pedido = new Pedido();
        pedido = mapper.readValue(json, Pedido.class); // Ooops
       
        pedidoDao.salvarOuAtualizarObjeto(pedido);
        
        return this.json = mapper.writeValueAsString(pedido);
    }

    //http://127.0.0.1:8080/CalcadosWebService/rest/pedido
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizar(String json) throws IOException {
        mapper = new ObjectMapper();
        // If we want to print the json formatted
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
                
        Pedido pedido = new Pedido();
        pedido = mapper.readValue(json, Pedido.class); // Ooops
       
        pedidoDao.salvarOuAtualizarObjeto(pedido);
        
        return this.json = mapper.writeValueAsString(pedido);      
    }

    //http://127.0.0.1:8080/CalcadosWebService/rest/pedido
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) throws JsonProcessingException {
        
        mapper = new ObjectMapper();
        // If we want to print the json formatted
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
                
        Pedido pedido = pedidoDao.buscarObjeto(codigo);
        pedidoDao.deletarObjeto(pedido);
        
        return this.json = mapper.writeValueAsString(pedido);
        
    }

}
