package br.univille.lojaproj.entity;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private int numeroVenda;

    public long getId() {
        return id;
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
