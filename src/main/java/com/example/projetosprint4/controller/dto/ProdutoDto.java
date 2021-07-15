package com.example.projetosprint4.controller.dto;

import com.example.projetosprint4.controller.form.ProdutoForm;
import com.example.projetosprint4.model.Produto;

import java.math.BigDecimal;

public class ProdutoDto {

    private Long id;
    private String descricao;
    private BigDecimal valor;

    public ProdutoDto() {
    }

    public ProdutoDto(Produto produto){
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
    }

    public ProdutoDto(Long id, String descricao, BigDecimal valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
