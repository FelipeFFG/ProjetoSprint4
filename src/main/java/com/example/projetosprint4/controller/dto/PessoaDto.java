package com.example.projetosprint4.controller.dto;

import com.example.projetosprint4.controller.form.PessoaForm;
import com.example.projetosprint4.model.Endereco;
import com.example.projetosprint4.model.Pessoa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PessoaDto {

    private String nome;
    private BigDecimal cpf;
    private List<EnderecoDto> endereco;

    public PessoaDto() {
        endereco = new ArrayList<>();
    }
    public PessoaDto(Pessoa pessoa) {
        endereco = new ArrayList<>();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.endereco = converteEndereco(pessoa.getEndereco());
    }

    public PessoaDto(PessoaForm pessoaForm){
        endereco = new ArrayList<>();
        this.nome = pessoaForm.getNome();
        this.cpf = pessoaForm.getCpf();
        this.endereco = converteEndereco(pessoaForm.getEndereco());
    }

    public List<EnderecoDto> converteEndereco(List<Endereco> enderecos) {
        EnderecoDto enderecoDto = new EnderecoDto();
        for (int i = 0; i < enderecos.size(); i++) {
            enderecoDto.setCidade(enderecos.get(i).getCidade());
            enderecoDto.setRua(enderecos.get(i).getRua());
            endereco.add(enderecoDto);
        }
        return endereco;
    }

    //Pecorre a lista de pessoas e cria um objeto Dto para cada pessoa na lista e converte os endereços para enderecosDto.
    public List<PessoaDto> convertePessoasparaPessoasDtoComEnderecoDto(List<Pessoa> Pessoas) {
        List<PessoaDto> TodasAsPessoasDto = new ArrayList<>();
        for (int i = 0; i < Pessoas.size(); i++) {
            PessoaDto pessoaDto = new PessoaDto();
            pessoaDto.setNome(Pessoas.get(i).getNome());
            pessoaDto.setCpf(Pessoas.get(i).getCpf());
            pessoaDto.converteEndereco(Pessoas.get(i).getEndereco());
            TodasAsPessoasDto.add(pessoaDto);
        }
        return TodasAsPessoasDto;
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
