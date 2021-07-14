package com.example.projetosprint4.repository;

import com.example.projetosprint4.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {


    Pessoa findPessoaByCpf(BigDecimal cpf);

}
