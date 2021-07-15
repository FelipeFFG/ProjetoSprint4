package com.example.projetosprint4.repository;

import com.example.projetosprint4.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository  extends JpaRepository<Produto,Long> {

    Produto findProdutoByDescricao(String descricao);


    Produto findProdutoById(Long id);
}
