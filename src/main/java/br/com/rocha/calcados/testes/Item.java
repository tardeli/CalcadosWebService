package br.com.rocha.calcados.testes;

import com.google.gson.annotations.Expose;

/**
 *
 * @author DaRocha
 */
public class Item {
    
    @Expose (serialize = true)
    long codigo;
    //@JsonIgnore
    @Expose (serialize = false)
    String quantidade;
    @Expose (serialize = true)
    Produto produto;
    
    @Expose (serialize = false)
    Pedido pedido;

    public Item() {
    }
    
    
    public Item(long codigo, String quantidade, Produto produto, Pedido pedido) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.produto = produto;
        this.pedido = pedido;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        if(pedido==null){
            pedido = new Pedido();
        }
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Item{" + "quantidade=" + quantidade + ", produto=" + produto +  '}';
    }
    
    
    
}
