package com.example.projetosprint4.controller.form;

import com.example.projetosprint4.controller.dto.PessoaDto;
import com.example.projetosprint4.model.Endereco;
import com.example.projetosprint4.model.Pessoa;
import com.example.projetosprint4.repository.EnderecoRepository;
import com.example.projetosprint4.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

    //PessoaForm - Pessoa
    public Pessoa converterPessoaFormParaPessoa( ){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.getNome());
        pessoa.setCpf(this.getCpf());
        pessoa.setSalario(this.getSalario());
        pessoa.setSexo(this.getSexo());
        pessoa.setEndereco(this.getEndereco());
        return pessoa;
    }

    //Salva a pessoa e o endereço no banco de dados.
    public PessoaForm save(Pessoa pessoa, PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository){
        Pessoa pessoabanco = pessoaRepository.findPessoaByCpf(pessoa.getCpf()); //procura se existe pessoa com o mesmo cpf no banco
        if (pessoabanco==null){
           for (int i =0;i<pessoa.getEndereco().size();i++){
               enderecoRepository.save(pessoa.getEndereco().get(i));// salva o enderço da pessoa no banco
           }
            pessoaRepository.save(pessoa);   //salva a pessoa no banco
            return new PessoaForm(pessoa.getNome(),pessoa.getCpf(),pessoa.getSalario(),pessoa.getSexo(),pessoa.getEndereco()); //retorna um objeto do tipo pessoa form
        }
        return null;
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
