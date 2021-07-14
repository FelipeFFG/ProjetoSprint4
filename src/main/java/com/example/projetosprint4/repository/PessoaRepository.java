package com.example.projetosprint4.repository;

import com.example.projetosprint4.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {


}
