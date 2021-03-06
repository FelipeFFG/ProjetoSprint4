package com.example.projetosprint4.controller.form;

import javax.validation.constraints.NotBlank;

public class EnderecoForm {

    @NotBlank(message = "Pais nao pode ser nulo ou vazio")
    private String pais;
    @NotBlank(message = "Estado nao pode ser nulo ou vazio")
    private String estado;
    @NotBlank(message = "Cidade nao pode ser nulo ou vazio")
    private String cidade;
    @NotBlank(message = "Cep nao pode ser nulo ou vazio")
    private String cep;
    @NotBlank(message = "Rua nao pode ser nulo ou vazio")
    private String rua;

    public EnderecoForm(String pais, String estado, String cidade, String cep, String rua) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
    }

    public EnderecoForm() {
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
