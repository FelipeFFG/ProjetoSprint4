package com.example.projetosprint4.controller;

import com.example.projetosprint4.controller.dto.PedidoDto;
import com.example.projetosprint4.controller.dto.ProdutoDto;
import com.example.projetosprint4.controller.form.PedidoForm;
import com.example.projetosprint4.model.Pedido;
import com.example.projetosprint4.model.Produto;
import com.example.projetosprint4.repository.PedidoRepository;
import com.example.projetosprint4.repository.ProdutoRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/protected/pedido")
public class PedidoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    @PutMapping()
    @Transactional
    public ResponseEntity<?> cadastrarPedido(@RequestBody PedidoForm pedidoForm){
        if (pedidoForm!=null){
            Pedido produtos = pedidoForm.save(produtoRepository,pedidoRepository);
            return new ResponseEntity<>(  pedidoForm.converte(produtos), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    //busca todos os pedidos.
    @GetMapping()
    public ResponseEntity<?>buscarPedidos(){
        List<Pedido> lista_pedidos = pedidoRepository.findAll();
        if (lista_pedidos!=null){
            return new ResponseEntity<>(new PedidoDto().converteListaPedidos(lista_pedidos),HttpStatus.OK);
        }else
            return ResponseEntity.notFound().build();
    }

    //busca os pedidos por Id.
    @GetMapping({"/{id}"})
    public ResponseEntity<?> buscarPedidosPorId(@PathVariable Long id){
        List<Pedido> lista_pedidos = pedidoRepository.findPedidoById(id);
        if (lista_pedidos!=null){
            return new ResponseEntity<>(new PedidoDto().converteListaPedidos(lista_pedidos),HttpStatus.OK);
        }else
            return ResponseEntity.notFound().build();
    }

}
