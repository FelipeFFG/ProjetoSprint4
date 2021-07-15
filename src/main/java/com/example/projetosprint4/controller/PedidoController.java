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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            PedidoDto produtos = pedidoForm.converte(produtoRepository,pedidoRepository);
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }



}
