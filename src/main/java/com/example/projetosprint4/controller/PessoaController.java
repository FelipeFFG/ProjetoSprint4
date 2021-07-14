package com.example.projetosprint4.controller;

import com.example.projetosprint4.controller.dto.EnderecoDto;
import com.example.projetosprint4.controller.dto.PessoaDto;
import com.example.projetosprint4.model.Pessoa;
import com.example.projetosprint4.repository.EnderecoRepository;
import com.example.projetosprint4.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;


    @GetMapping
    public ResponseEntity<?> buscarTodasAsPessoas(){
        List<Pessoa> TodasAsPessoas = pessoaRepository.findAll();
        List<PessoaDto> TodasAsPessoasDto = new ArrayList<>();
        for (int i=0;i<TodasAsPessoas.size();i++){
            PessoaDto pessoaDto= new PessoaDto();
            pessoaDto.setNome(TodasAsPessoas.get(i).getNome());
            pessoaDto.setCpf(TodasAsPessoas.get(i).getCpf());
            pessoaDto.converteEndereco(TodasAsPessoas.get(i).getEndereco());
            TodasAsPessoasDto.add(pessoaDto);
        }
        return new ResponseEntity<>(TodasAsPessoasDto, HttpStatus.OK);
    }
}

