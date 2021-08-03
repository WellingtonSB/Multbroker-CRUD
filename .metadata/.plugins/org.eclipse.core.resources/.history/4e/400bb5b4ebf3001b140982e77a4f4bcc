package com.wsb.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "pessoa_db")
public class PessoaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Preenchimento obrigatorio!")
	private String nome;
	
	@NotNull(message="Preenchimento obrigatorio!")
	private String idade;
	
	@Email
	@NotNull(message="Preenchimento obrigatorio!")
	private String email;

	
	
	public PessoaModel() {
		super();
	}
	
	public PessoaModel(long id, @NotNull(message = "Preenchimento obrigatorio!") String nome,
			@NotNull(message = "Preenchimento obrigatorio!") String idade,
			@Email @NotNull(message = "Preenchimento obrigatorio!") String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaModel other = (PessoaModel) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
