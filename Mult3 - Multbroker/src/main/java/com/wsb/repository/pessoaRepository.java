package com.wsb.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wsb.model.PessoaModel;

@Repository
public interface pessoaRepository extends JpaRepository <PessoaModel,Long> {
	public List<PessoaModel>findByNomeContainingIgnoreCase(String nome);
	public Optional<PessoaModel> findByEmail(String email);
}
