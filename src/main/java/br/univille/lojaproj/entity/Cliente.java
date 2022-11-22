package br.univille.lojaproj.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Campo nome nao pode ser em branco")
    private String nome;
    @Column(length = 3000)
    @NotEmpty(message = "Campo endereco nao pode tar vazio")
    private String endereco;
    @Pattern(regexp = "Masculino|Feminino", flags = Pattern.Flag.CANON_EQ, message = "Valor invalido, utlilize Masculino ou Feminino")
    private String sexo;
    @NotEmpty(message = "Campo endereco nao pode tar vazio")
    private String telefone;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Nao pode tar nulo")
    private Date dataNascimento;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Cidade cidadeResidencia;
    
    public long getId() {
        return id;
    }
    public Cidade getCidadeResidencia() {
        return cidadeResidencia;
    }
    public void setCidadeResidencia(Cidade cidadeResidencia) {
        this.cidadeResidencia = cidadeResidencia;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
}
