package com.example.projetosprint4.controller.form;

import com.example.projetosprint4.model.Endereco;
import com.example.projetosprint4.model.Pessoa;
import com.example.projetosprint4.repository.PessoaRepository;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

public class PessoaForm {

    @NotBlank(message = "CPF nao pode ser nulo ou vazio")
    private String nome;
    @NotBlank(message = "CPF nao pode ser nulo ou vazio")
    private BigDecimal cpf;
    @NotBlank(message = "SALARIO nao pode ser nulo ou vazio")
    private BigDecimal salario;
    @NotBlank(message = "SEXO nao pode ser nulo ou vazio")
    private String sexo;
    @NotBlank(message = "ENDEREÇO nao pode ser nulo ou vazio")
    private List<Endereco> enderecos;

    public Pessoa coverter(PessoaRepository pessoaRepository) throws Exception {
        Pessoa pessoa = pessoaRepository.findPessoaByCpf(this.cpf);
        if (pessoa != null){
          return  new Pessoa(this.nome,this.cpf,this.salario,this.sexo,this.enderecos);
        }else
           throw new Exception("nao foi posivel adicionar a pessoa ao banco de dados.");
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
