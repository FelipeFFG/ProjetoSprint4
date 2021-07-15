package com.example.projetosprint4.controller.dto;

import com.example.projetosprint4.model.Pedido;
import com.example.projetosprint4.model.Produto;

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

    public List<ProdutoDto> converteListaProdutosParaProdutosDto(List<Produto> lista_produto){
        List<ProdutoDto> lista_produtodto = new ArrayList<>();
        for (int i =0;i<lista_produto.size();i++){
            ProdutoDto produtoDto = new ProdutoDto();
            produtoDto.setId(lista_produto.get(i).getId());
            produtoDto.setDescricao(lista_produto.get(i).getDescricao());
            produtoDto.setValor(lista_produto.get(i).getValor());
            lista_produtodto.add(produtoDto);
        }
        return lista_produtodto;
    }

    public List<PedidoDto> converteListaPedidos(List<Pedido> lista_pedidos) {
        List<PedidoDto> pedidoDtoList = new ArrayList<>();
        for (int i=0;i<lista_pedidos.size();i++){
            PedidoDto pedidoDto = new PedidoDto();
            pedidoDto.setProdutoDtoList(converteListaProdutosParaProdutosDto(lista_pedidos.get(i).getProdutos()));
            pedidoDto.setTotal(lista_pedidos.get(i).getTotal());
            pedidoDtoList.add(pedidoDto);
        }
        return pedidoDtoList;
    }
}
