package br.univille.lojaproj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float valorTotal;
    private String tipo;
    private int numeroParcelas;
    private Date data;
    

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getNumeroParcelas() {
        return numeroParcelas;
    }
    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    
}