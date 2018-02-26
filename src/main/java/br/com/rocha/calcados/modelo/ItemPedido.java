package br.com.rocha.calcados.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *
 * @author Tardeli
 */
@Entity
public class ItemPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
     
    @ManyToOne
    @JsonBackReference
    @JoinColumn(nullable = true) 
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(nullable = true)
    private Produto produto;
    
    @Column(length = 10)
    private String tamanho;
    
    private int quantidade;
    
    @Column(scale = 7, precision = 2)
    private Double total;

    public ItemPedido() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Pedido getPedido() {
        if(pedido == null){
            return pedido = new Pedido();
        }
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        if(produto==null){
            return produto = new Produto();
        }
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPedido other = (ItemPedido) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemPedido{" + "codigo=" + codigo + ", tamanho=" + tamanho + ", quantidade=" + quantidade + ", total=" + total + '}';
    }

}

  
