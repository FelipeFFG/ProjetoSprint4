package com.example.projetosprint4.controller.form;


import com.example.projetosprint4.controller.dto.PedidoDto;
import com.example.projetosprint4.controller.dto.ProdutoDto;
import com.example.projetosprint4.model.Pedido;
import com.example.projetosprint4.model.Produto;
import com.example.projetosprint4.repository.PedidoRepository;
import com.example.projetosprint4.repository.ProdutoRepository;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PedidoForm {

    @NotEmpty(message = "Lista De Pedidos nao pode estar vazio")
    private List<Long> listaPedidos;

    public List<Long> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Long> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Pedido save(ProdutoRepository produtoRepository, PedidoRepository pedidoRepository) {
        Pedido pedido = new Pedido();
        int valor = 0;
        for (int i = 0; i < listaPedidos.size(); i++) {
            Produto produto = produtoRepository.findProdutoById(listaPedidos.get(i));
            pedido.getProdutos().add(produto);
            valor += produto.getValor().intValue();
        }
        pedido.setTotal(new BigDecimal(valor));
        pedidoRepository.save(pedido);
        return pedido;
    }


    public PedidoDto converte(Pedido pedido) {
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setTotal(pedido.getTotal());
        List<ProdutoDto> produtoDtoList = new ArrayList<>();
        for (int i = 0; i < pedido.getProdutos().size(); i++) {
            ProdutoDto produtoDto = new ProdutoDto(pedido.getProdutos().get(i));
            produtoDtoList.add(produtoDto);
        }
        pedidoDto.setProdutoDtoList(produtoDtoList);
        return pedidoDto;
    }

    public Pedido atualizar(Long id, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        Pedido pedido = pedidoRepository.getOne(id);
        int valor = 0;
        for (int i = 0; i < pedido.getProdutos().size(); i++) {
            pedido.setProdutos(new ArrayList<>());
        }
        for (int i = 0; i < listaPedidos.size(); i++) {
            Produto produto = produtoRepository.findProdutoById(listaPedidos.get(i));
            pedido.getProdutos().add(produto);
            valor += produto.getValor().intValue();
        }
        pedido.setTotal(new BigDecimal(valor));
        return pedido;
    }

    public Pedido deletar(Long id, PedidoRepository pedidoRepository) {
        Pedido pedido = pedidoRepository.getOne(id);
        pedido.setStatus(false);
        pedidoRepository.save(pedido);
        return pedido;
    }
}


