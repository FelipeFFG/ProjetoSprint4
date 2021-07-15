package com.example.projetosprint4.controller.form;

import com.example.projetosprint4.model.Produto;
import com.example.projetosprint4.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.Optional;

public class ProdutoForm {

    private String descricao;
    private BigDecimal valor;

    public ProdutoForm() {
    }


    public ProdutoForm(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
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

    public Produto coverteProduto() {
        Produto produto = new Produto(this.descricao,this.valor);
        return produto;
    }

    public Produto save(Produto produto, ProdutoRepository produtoRepository) {
        Produto produtodb = produtoRepository.findProdutoByDescricao(produto.getDescricao());
        if (produtodb==null){
            return produto;
        }
        return null;
    }
}
