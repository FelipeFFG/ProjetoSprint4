package com.example.projetosprint4.controller.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PedidoDto {


    private BigDecimal total;
    private List<ProdutoDto> produtoDtoList;

    public PedidoDto(BigDecimal total, List<ProdutoDto> produtoDtoList) {
        this.total = total;
        this.produtoDtoList = produtoDtoList;
    }

    public PedidoDto() {
        total = new BigDecimal(0.0);
        produtoDtoList = new ArrayList<>();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ProdutoDto> getProdutoDtoList() {
        return produtoDtoList;
    }

    public void setProdutoDtoList(List<ProdutoDto> produtoDtoList) {
        this.produtoDtoList = produtoDtoList;
    }
}
