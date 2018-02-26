package br.com.rocha.calcados.teste;

import br.com.rocha.calcados.dao.ClienteDao;
import br.com.rocha.calcados.modelo.Cliente;
import com.google.gson.Gson;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author DaRocha
 */
public class ClienteTeste {
    ClienteDao dao = new  ClienteDao();
    @Test
    @Ignore
    public void consultarClientes(){
        
        List<Cliente> clientes = dao.pesquisarCliente("silv");
        
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome()+"\n");
        }
        
    
    }
    
    @Test
    @Ignore
    public void converterGson(){
        Cliente cliente = dao.buscarObjeto(1L);
        
         Gson g = new Gson();
         System.out.println(g.toJson(cliente));
    }
}
