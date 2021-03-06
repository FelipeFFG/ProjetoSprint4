package com.example.projetosprint4.controller;

import com.example.projetosprint4.controller.dto.ProdutoDto;
import com.example.projetosprint4.controller.form.ProdutoForm;
import com.example.projetosprint4.model.Produto;
import com.example.projetosprint4.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("protected/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastraProduto(@Valid @RequestBody ProdutoForm produtoForm) {
        if (produtoForm != null) {
            Produto produto = produtoForm.coverteProduto();
            Produto produtodb = produtoRepository.findProdutoByDescricao(produto.getDescricao());
            if (produtodb == null) {
                produtoRepository.save(produto);
                return new ResponseEntity<>(new ProdutoDto(produto), HttpStatus.CREATED);
            }else
                return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Retorna os produtos que estiverem disponiveis.
    @GetMapping()
    public ResponseEntity<List<ProdutoDto>> buscarTodosOsProdutos() {
        List<Produto> produto = produtoRepository.findAll();
        List<ProdutoDto> listaProdutosDto = new ArrayList<>();
        if (!produto.isEmpty()) {
            for (int i = 0; i < produto.size(); i++) {
                if (produto.get(i).isStatus() == true) {
                    listaProdutosDto.add(new ProdutoDto(produto.get(i)));
                }
            }
            return ResponseEntity.ok(listaProdutosDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscarProdutosPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return  ResponseEntity.ok(new ProdutoDto(produto.get()));
        }
        return ResponseEntity.notFound().build();
    }

    //Altera o produto, podendo mudar o status do mesmo.
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDto> alterarProduto(@PathVariable Long id,@Valid @RequestBody ProdutoForm produtoForm) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            Produto produtoAtualizado = produtoForm.atualizar(id, produtoRepository);
            return new ResponseEntity<>(new ProdutoDto(produtoAtualizado), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    //Marca o produto como deletado.
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            ProdutoForm produtoForm = new ProdutoForm();
            produtoForm.deletar(id, produtoRepository);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
