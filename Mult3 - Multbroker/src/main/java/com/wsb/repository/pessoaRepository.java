package com.wsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wsb.model.PessoaModel;

@Repository
public interface pessoaRepository extends JpaRepository <PessoaModel,Long> {

}
