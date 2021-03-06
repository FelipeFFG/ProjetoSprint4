package com.example.projetosprint4.controller;

import com.example.projetosprint4.controller.dto.PessoaDto;
import com.example.projetosprint4.controller.dto.PessoaDtoID;
import com.example.projetosprint4.controller.form.PessoaForm;
import com.example.projetosprint4.model.Pessoa;
import com.example.projetosprint4.repository.EnderecoRepository;
import com.example.projetosprint4.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    //Cadastrar pessoa no banco de dados.
    @PostMapping
    public ResponseEntity<PessoaDto> cadastrar(@Valid @RequestBody PessoaForm pessoaForm) {
        if (pessoaForm != null) {
            Pessoa pessoa = pessoaForm.converterPessoaFormParaPessoa();
            Pessoa pessoaCheck = pessoaForm.save(pessoa, pessoaRepository, enderecoRepository);
            return new ResponseEntity<>( new PessoaDto(pessoaCheck), HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();

    }

    //Buscar Todas as pessoas.
    @GetMapping
    public ResponseEntity<List<PessoaDto>> buscarTodasAsPessoas() {
        List<Pessoa> TodasAsPessoas = pessoaRepository.findAll();
        if (TodasAsPessoas != null) {
            return  ResponseEntity.ok(new PessoaDto().convertePessoasparaPessoasDtoComEnderecoDto(TodasAsPessoas));
        } else
            return ResponseEntity.notFound().build();
    }

    //Buscar Por ID.
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDtoID> BuscarPorId(@PathVariable Long id) {
        Optional<Pessoa> TodasAsPessoas = pessoaRepository.findById(id);
        if (TodasAsPessoas.isPresent()) {
            return ResponseEntity.ok(new PessoaDtoID(TodasAsPessoas.get()));
        } else
            return ResponseEntity.notFound().build();
    }

    //Deletar Pessoa do banco de dados.
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            pessoaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody PessoaForm form) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            Pessoa pessoaAtualizada = form.atualizar(id, pessoaRepository, enderecoRepository);
            return ResponseEntity.ok(new PessoaDto(pessoaAtualizada));
        }
        return ResponseEntity.notFound().build();
    }


}

