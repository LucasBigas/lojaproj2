package br.univille.lojaproj.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Nao pode ser nulo o valor da data")
    private Date data;
    @Min(value = 1, message = "Precisa ser um numero maior que zero")
    private int numeroVenda;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Cliente comprador;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Atendente vendedor;

    public long getId() {
        return id;
    }
    public Atendente getVendedor() {
        return vendedor;
    }
    public void setVendedor(Atendente vendedor) {
        this.vendedor = vendedor;
    }
    public Cliente getComprador() {
        return comprador;
    }
    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public int getNumeroVenda() {
        return numeroVenda;
    }
    public void setNumeroVenda(int numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    
}
