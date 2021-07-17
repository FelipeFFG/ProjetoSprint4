package com.example.projetosprint4.controller.form;

import com.example.projetosprint4.model.Endereco;
import com.example.projetosprint4.model.Pessoa;
import com.example.projetosprint4.repository.EnderecoRepository;
import com.example.projetosprint4.repository.PessoaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PessoaForm {

    @NotBlank(message = "Nome nao pode ser nulo ou vazio")
    private String nome;
    @NotNull
    private BigDecimal cpf;
    @NotNull
    private BigDecimal salario;
    @NotBlank(message = "sexo nao pode ser nulo ou vazio")
    private String sexo;
    @NotEmpty(message = "Endereco nao pode estar vazio")
    private List<EnderecoForm> endereco;


    public PessoaForm(String nome, BigDecimal cpf, BigDecimal salario, String sexo, List<EnderecoForm> endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public PessoaForm() {
    }

    //PessoaForm - Pessoa
    public Pessoa converterPessoaFormParaPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.getNome());
        pessoa.setCpf(this.getCpf());
        pessoa.setSalario(this.getSalario());
        pessoa.setSexo(this.getSexo());
        pessoa.setEndereco(converteEnderecoFormParaEndereco());
        return pessoa;
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

    public List<EnderecoForm> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoForm> endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> converteEnderecoFormParaEndereco() {
        List<Endereco> listaEndereco = new ArrayList<>();
        for (int i = 0; i < endereco.size(); i++) {
            Endereco novoEnderco = new Endereco();
            novoEnderco.setCep(endereco.get(i).getCep());
            novoEnderco.setPais(endereco.get(i).getPais());
            novoEnderco.setCidade(endereco.get(i).getCidade());
            novoEnderco.setRua(endereco.get(i).getRua());
            novoEnderco.setEstado(endereco.get(i).getEstado());
            listaEndereco.add(novoEnderco);
        }
        return listaEndereco;

    }

    public Pessoa atualizar(Long id, PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
        Pessoa pessoa = pessoaRepository.getOne(id);
        pessoa.setNome(this.nome);
        pessoa.setCpf(this.cpf);
        pessoa.setSexo(this.sexo);
        List<Endereco> listaEndereco = new ArrayList<>();
        for (int i = 0; i < pessoa.getEndereco().size(); i++) {
            enderecoRepository.delete(pessoa.getEndereco().get(i));
        }
        for (int i = 0; i < this.endereco.size(); i++) {
            Endereco enderocodb = new Endereco(endereco.get(i).getPais(), endereco.get(i).getEstado(), endereco.get(i).getCidade(), endereco.get(i).getCep(), endereco.get(i).getRua());
            enderecoRepository.save(enderocodb);
            listaEndereco.add(enderocodb);
        }
        pessoa.setEndereco(listaEndereco);
        return pessoa;
    }

    //Salva a pessoa e o endereço no banco de dados.
    public Pessoa save(Pessoa pessoa, PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
        Pessoa pessoabanco = pessoaRepository.findPessoaByCpf(pessoa.getCpf()); //procura se existe pessoa com o mesmo cpf no banco
        if (pessoabanco == null) {
            for (int i = 0; i < pessoa.getEndereco().size(); i++) {
                enderecoRepository.save(pessoa.getEndereco().get(i));// salva o enderço da pessoa no banco
            }
            pessoaRepository.save(pessoa);   //salva a pessoa no banco
            return pessoa; //retorna um objeto do tipo pessoa form
        }
        return null;
    }


}
