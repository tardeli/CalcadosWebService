package br.com.rocha.calcados.testes;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DaRocha
 */
public class Pedido {
    
    @Expose (serialize = true)
    long codigo;
    @Expose (serialize = true)
    String total;
    @Expose (serialize = true)
    String data;
    
    //@JsonBackReference
    //@JsonManagedReference
    
    @Expose (serialize = true)
    List<Item> itens;

    public Pedido() {
    }
    
    

    public Pedido(long codigo, String total, String data, List<Item> itens) {
        this.codigo = codigo;
        this.total = total;
        this.data = data;
        this.itens = itens;
    }
   
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Item> getItens() {
        if(itens==null){
            itens = new ArrayList<>();
        }
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", total=" + total + ", data=" + data + ", itens=" + itens + '}';
    }
    
    
             
}
