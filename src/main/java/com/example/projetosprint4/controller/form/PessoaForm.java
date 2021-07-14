package com.example.projetosprint4.controller.form;

import com.example.projetosprint4.controller.dto.PessoaDto;
import com.example.projetosprint4.model.Endereco;
import com.example.projetosprint4.model.Pessoa;
import com.example.projetosprint4.repository.PessoaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class PessoaForm {


    private String nome;

    private BigDecimal cpf;

    private BigDecimal salario;

    private String sexo;

    private List<Endereco> endereco ;

    public PessoaForm(String nome, BigDecimal cpf, BigDecimal salario, String sexo, List<Endereco> endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public PessoaForm() {
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
