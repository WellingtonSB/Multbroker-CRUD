package com.wsb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsb.model.PessoaModel;
import com.wsb.repository.pessoaRepository;

@Service
public class pessoaService {

	@Autowired
	private pessoaRepository repository;
	
	public Optional<PessoaModel> cadastrarPessoa(PessoaModel pessoa){
		if(repository.findByEmail(pessoa.getEmail()).isPresent()) {
			return null;
		}
		return Optional.of(repository.save(pessoa));
	}
}
