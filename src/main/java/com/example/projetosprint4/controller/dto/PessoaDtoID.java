package com.example.projetosprint4.controller.dto;

import com.example.projetosprint4.model.Endereco;
import com.example.projetosprint4.model.Pessoa;

import java.math.BigDecimal;
import java.util.List;

public class PessoaDtoID {


    private Long id;
    private String nome;
    private BigDecimal cpf;
    private BigDecimal salario;
    private String sexo;
    private List<Endereco> endereco;

    public PessoaDtoID() {
    }

    public PessoaDtoID(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.salario = pessoa.getSalario();
        this.sexo = pessoa.getSexo();
        this.endereco = pessoa.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getCpf() {
        return cpf;
    }

    public void setCpf(BigDecimal cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}
