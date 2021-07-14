package com.example.projetosprint4.controller;

import com.example.projetosprint4.controller.dto.PessoaDto;
import com.example.projetosprint4.controller.form.PessoaForm;
import com.example.projetosprint4.model.Endereco;
import com.example.projetosprint4.model.Pessoa;
import com.example.projetosprint4.repository.EnderecoRepository;
import com.example.projetosprint4.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller("/pessoa")
public class PessoaController {


    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public  ResponseEntity<PessoaDto> cadastrar(@Valid @RequestBody PessoaForm pessoaForm) throws Exception {
        if (pessoaForm !=null){
            Pessoa pessoa = pessoaForm.coverter(pessoaRepository);
            pessoaRepository.save(pessoa);
            for (int i = 0;i<pessoa.getEndereco().size();i++){
                Endereco endereco = new Endereco(pessoa.getEndereco().get(i));
                enderecoRepository.save(endereco);
            }
            return new ResponseEntity<>(new PessoaDto(pessoaForm), HttpStatus.OK);
        }else
            throw new Exception();
    }
}

