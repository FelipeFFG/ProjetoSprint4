package com.example.projetosprint4.controller.dto;

import com.example.projetosprint4.model.Endereco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PessoaDto {

    private String nome;
    private BigDecimal cpf;
    private List<EnderecoDto> endereco;



    public PessoaDto(String nome, BigDecimal cpf, List<EnderecoDto> enderecosDto) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = enderecosDto;
    }

    public List<EnderecoDto> converteEndereco(List<Endereco> enderecos){
        EnderecoDto  enderecoDto = new EnderecoDto();
        for (int i =0;i<enderecos.size();i++){
            enderecoDto.setCidade(enderecos.get(i).getCidade());
            enderecoDto.setRua(enderecos.get(i).getRua());
            endereco.add(enderecoDto);
        }
       return endereco;
    }

    public PessoaDto() {
        endereco = new ArrayList<>();
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

    public List<EnderecoDto> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoDto> endereco) {
        this.endereco = endereco;
    }
}
