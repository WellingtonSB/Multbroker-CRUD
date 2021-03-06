package com.wsb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsb.model.PessoaModel;
import com.wsb.repository.pessoaRepository;
import com.wsb.service.pessoaService;

@RestController
@RequestMapping("/pessoa")
public class pessoaController {

	@Autowired
	private pessoaRepository repository;
	
	@Autowired
	private pessoaService service;
	
	
	@GetMapping
	public ResponseEntity<List<PessoaModel>>getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaModel>getById(@PathVariable long id){
		return repository.findById(id).map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<PessoaModel>>getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<PessoaModel>postPessoa(@RequestBody PessoaModel pessoa){
		Optional<PessoaModel> resp = service.cadastrarPessoa(pessoa);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(resp.get());
		}catch(Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<PessoaModel>putPessoa(@RequestBody PessoaModel pessoa){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}
