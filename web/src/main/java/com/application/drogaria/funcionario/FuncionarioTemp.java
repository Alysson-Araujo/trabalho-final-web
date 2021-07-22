package com.application.drogaria.funcionario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class FuncionarioTemp {
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	private Double salario;
	
	@Deprecated
	public FuncionarioTemp() {}

	
	
	public FuncionarioTemp(@NotBlank String cpf, @NotBlank String nome, @NotBlank String telefone,
			@NotBlank @Email String email, Double salario) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.salario = salario;
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}

	public Double getSalario() {
		return salario;
	}

	public Funcionario toModel() {
		return new Funcionario(this.cpf, this.nome, this.telefone, this.email, this.salario);
	}
}
