package com.example.projetosprint4.controller;

import com.example.projetosprint4.controller.dto.PessoaDto;
import com.example.projetosprint4.controller.form.PessoaForm;
import com.example.projetosprint4.model.Pessoa;
import com.example.projetosprint4.repository.EnderecoRepository;
import com.example.projetosprint4.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> cadastrar(@Valid @RequestBody PessoaForm pessoaForm){
        if (pessoaForm!=null){
            Pessoa pessoa = pessoaForm.converterPessoaFormParaPessoa();
            PessoaForm pessoaCheck = pessoaForm.save(pessoa,pessoaRepository,enderecoRepository);
            PessoaDto pessoaDto = new PessoaDto(pessoaCheck);
            return new ResponseEntity<>(pessoaDto,HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }

    //Buscar Todas as pessoas
    @GetMapping
    public ResponseEntity<?> buscarTodasAsPessoas() {
        List<Pessoa> TodasAsPessoas = pessoaRepository.findAll();
        if (TodasAsPessoas != null) {
            return new ResponseEntity<>(new PessoaDto()
                    .convertePessoasparaPessoasDtoComEnderecoDto(TodasAsPessoas), HttpStatus.OK);
        } else
            return ResponseEntity.notFound().build();
    }

    //Buscar Por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarPorId(@PathVariable Long id) {
        Optional<Pessoa> TodasAsPessoas = pessoaRepository.findById(id);
        if (TodasAsPessoas.isPresent()) {
            return ResponseEntity.ok(new PessoaDto(TodasAsPessoas.get()));
        } else
            return ResponseEntity.notFound().build();
    }






//Metodo put de atulizar um cadastro.
  /*  @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PessoaDto> atualizarCadastro(@PathVariable Long id, @Valid @RequestBody PessoaForm pessoaForm){
        Optional<Pessoa> optionalPessoaDto = pessoaRepository.findById(id);
        if (optionalPessoaDto.isPresent()){
            Pessoa pessoa =pessoaForm.atualizar(id,pessoaRepository);
            return ResponseEntity.ok(new PessoaDto(pessoa));
        }
        return ResponseEntity.notFound().build();
    }*/


}

