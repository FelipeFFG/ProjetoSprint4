package com.example.projetosprint4.controller.form;

import com.example.projetosprint4.controller.dto.PedidoDto;
import com.example.projetosprint4.controller.dto.ProdutoDto;
import com.example.projetosprint4.model.Pedido;
import com.example.projetosprint4.model.Produto;
import com.example.projetosprint4.repository.PedidoRepository;
import com.example.projetosprint4.repository.ProdutoRepository;
import org.springframework.objenesis.instantiator.perc.PercInstantiator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public class PedidoForm {

    private List<Long> listaPedidos;

    public List<Long> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Long> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public PedidoDto savae(ProdutoRepository produtoRepository, PedidoRepository pedidoRepository) {
        PedidoDto pedido = new PedidoDto();
        Pedido pedidodb = new Pedido();
        int valor=0;
        for (int i=0;i<listaPedidos.size();i++){
            Produto produto = produtoRepository.findProdutoById(listaPedidos.get(i));
            ProdutoDto produtoDto = new ProdutoDto(produto);
            pedido.getProdutoDtoList().add(produtoDto);
            valor +=produto.getValor().intValue();
            pedidodb.getProdutos().add(produto);
        }
        pedidodb.setTotal(new BigDecimal(valor));
        pedido.setTotal(new BigDecimal(valor));
        pedidoRepository.save(pedidodb);
        return pedido;
    }

    public Pedido save(ProdutoRepository produtoRepository, PedidoRepository pedidoRepository) {
        Pedido pedido = new Pedido();
        int valor=0;
        for (int i=0;i<listaPedidos.size();i++){
            Produto produto = produtoRepository.findProdutoById(listaPedidos.get(i));
            pedido.getProdutos().add(produto);
            valor +=produto.getValor().intValue();
        }
        pedido.setTotal(new BigDecimal(valor));
        pedidoRepository.save(pedido);
        return pedido;
    }


    public PedidoDto converte(Pedido pedido) {
      PedidoDto pedidoDto = new PedidoDto();
      pedidoDto.setTotal(pedido.getTotal());
      List<ProdutoDto> produtoDtoList = new ArrayList<>();
      for (int i = 0; i< pedido.getProdutos().size();i++){
          ProdutoDto produtoDto = new ProdutoDto(pedido.getProdutos().get(i));
          produtoDtoList.add(produtoDto);
      }
      pedidoDto.setProdutoDtoList(produtoDtoList);
      return pedidoDto;
    }

    public Pedido atualizar(Long id, PedidoRepository pedidoRepository,ProdutoRepository produtoRepository) {
        Pedido pedido = pedidoRepository.getOne(id);
        int valor =0;
        for (int i =0; i <pedido.getProdutos().size();i++){
            pedido.setProdutos(new ArrayList<>());
        }
        for (int i=0;i<listaPedidos.size();i++) {
            Produto produto = produtoRepository.findProdutoById(listaPedidos.get(i));
            pedido.getProdutos().add(produto);
            valor +=produto.getValor().intValue();
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


