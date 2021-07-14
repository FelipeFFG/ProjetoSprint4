package com.example.projetosprint4.controller.dto;

import com.example.projetosprint4.controller.form.PessoaForm;
import com.example.projetosprint4.model.Endereco;

import java.math.BigDecimal;
import java.util.List;

public class PessoaDto {

    private String nome;
    private BigDecimal cpf;

    private List<Endereco> enderecos;


    public PessoaDto(PessoaForm pessoaForm){
        this.nome =pessoaForm.getNome();
        this.cpf = pessoaForm.getCpf();
        this.enderecos = pessoaForm.getEnderecos();

    }
}
