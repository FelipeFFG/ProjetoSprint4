package com.example.projetosprint4.controller;

import com.example.projetosprint4.controller.dto.ProdutoDto;
import com.example.projetosprint4.controller.form.ProdutoForm;
import com.example.projetosprint4.model.Pessoa;
import com.example.projetosprint4.model.Produto;
import com.example.projetosprint4.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("protected/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<?> cadastraProduto(@RequestBody ProdutoForm produtoForm){
        if (produtoForm!=null){
            Produto produto = produtoForm.coverteProduto();
            Produto produtoCheck = produtoForm.save(produto,produtoRepository);
            Produto adicionado=produtoRepository.save(produtoCheck);
            return new ResponseEntity<>(new ProdutoDto(adicionado), HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping()
    public ResponseEntity<?> buscarTodosOsProdutos(){
       List<Produto> produto =produtoRepository.findAll();
       List<ProdutoDto> listaProdutosDto = new ArrayList<>();
       if (!produto.isEmpty()){
           for (int i=0;i<produto.size();i++){
               listaProdutosDto.add(new ProdutoDto(produto.get(i)));
           }
           return new ResponseEntity<>(listaProdutosDto, HttpStatus.OK);
       }
        return ResponseEntity.notFound().build();
    }



}
