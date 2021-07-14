package com.example.projetosprint4.controller.dto;

import com.example.projetosprint4.model.Endereco;

import java.util.ArrayList;
import java.util.List;

public class EnderecoDto {

    private String cidade;
    private String rua;

    public EnderecoDto(String cidade, String rua) {
        this.cidade = cidade;
        this.rua = rua;
    }

    public EnderecoDto() {
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
