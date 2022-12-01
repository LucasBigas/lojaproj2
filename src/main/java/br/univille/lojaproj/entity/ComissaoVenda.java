package br.univille.lojaproj.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ComissaoVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Nao pode tar nulo")
    private Date data;
    private float valor;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Atendente vendedor;
    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Venda venda;
    

    public Venda getVenda() {
        return venda;
    }
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    public long getId() {
        return id;
    }
    public Atendente getVendedor() {
        return vendedor;
    }
    public void setVendedor(Atendente vendedor) {
        this.vendedor = vendedor;
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
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    
}
