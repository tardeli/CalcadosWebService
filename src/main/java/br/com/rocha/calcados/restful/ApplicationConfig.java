package br.com.rocha.calcados.restful;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author DaRocha
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.rocha.calcados.restful.ClienteWs.class);
        resources.add(br.com.rocha.calcados.restful.PedidoWs.class);
        resources.add(br.com.rocha.calcados.restful.ProdutoWs.class);
    }
    
}
