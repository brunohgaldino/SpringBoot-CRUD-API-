package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Pessoa;
import com.example.postgresdemo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

      
    /* busca dados dos clientes cadastrados*/
    @GetMapping("/pessoas")
    public Page<Pessoa> getPessoas(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }


    /* insere dados de umn novo cliente*/
    @PostMapping("/pessoas")
    public Pessoa createQuestion(@Valid @RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
   
    /* deleta dados dos clientes cadastrados*/
    @DeleteMapping("/pessoas/{CPF}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long CPF) {
        return pessoaRepository.findById(CPF)
                .map(pessoa -> {
                	pessoaRepository.delete(pessoa);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Usuário com CPF " + CPF));
    }
    
    /* altera dados dos clientes cadastrados*/
    @PutMapping("/pessoas/{CPF}")
    public Pessoa updatePessoa(@PathVariable Long CPF,@Valid @RequestBody Pessoa pessoaRequest) {
        if(!pessoaRepository.existsById(CPF)) {
            throw new ResourceNotFoundException("Usuário com CPF " + CPF);
        }

        return pessoaRepository.findById(CPF)
                .map(pessoa -> {
                	pessoa.setnome(pessoaRequest.getnome());                
                	pessoa.setRua(pessoaRequest.getRua());
                	pessoa.setBairro(pessoaRequest.getBairro());
                	pessoa.setData_Nasc(pessoaRequest.getData_Nasc());
                    return pessoaRepository.save(pessoa);
                }).orElseThrow(() -> new ResourceNotFoundException("Usuário com CPF " + CPF));
    }
    
}
