package com.example.projetosprint4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

    @Id
    private Long id;
    @NotBlank(message = "PAIS nao pode ser nulo ou vazio")
    private String pais;
    @NotBlank(message = "ESTADO nao pode ser nulo ou vazio")
    private String estado;
    @NotBlank(message = "CIDADE nao pode ser nulo ou vazio")
    private String cidade;
    @NotBlank(message = "CEP nao pode ser nulo ou vazio")
    private String cep;
    @NotBlank(message = "RUA nao pode ser nulo ou vazio")
    private String rua;

    public Endereco(Long id, String pais, String estado, String cidade, String cep, String rua) {
        this.id = id;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
    }

    public Endereco(Endereco endereco) {
        cep =endereco.getCep();
        pais = endereco.getPais();
        estado =endereco.getEstado();
        cidade = endereco.getCidade();
        cep = endereco.getCep();
        rua = endereco.getRua();
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
