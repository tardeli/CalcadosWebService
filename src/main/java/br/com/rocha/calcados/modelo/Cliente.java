package br.com.rocha.calcados.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DaRocha
 */
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{
        
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long codigo;
    
    @Column(length = 50)
    private String nome;
    
    @Column(length = 14, unique = true)
    private String cpf;
    
    @Column(length = 50)
    private String razaoSocial;
    
    @Column(length = 18, unique = true)
    private String cnpj;
    
    @Column(length = 30)
    private String email;
    
    @Column(length = 10)
    private String telefone;
    
    @Column(length = 10)
    private String celular;
    
    @Column(length = 50)
    private String logradouro;
    
    @Column(length = 25)
    private String bairro;
    
    @Column(length = 40)
    private String pontoReferencia;

    public Cliente() {
    }
    
            
    public Cliente(String nome, String cpf, String razaoSocial, String cnpj, String email, String telefone, String celular, String logradouro, String bairro, String pontoReferencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codigo);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", email=" + email + ", telefone=" + telefone + ", celular=" + celular + ", logradouro=" + logradouro + ", bairro=" + bairro + ", pontoReferencia=" + pontoReferencia + '}';
    }
    
}
