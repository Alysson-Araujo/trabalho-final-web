package com.application.drogaria.funcionario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ListaDetalhesFuncionario {
	String cpf;
	
	String nome;
	
	String telefone;
	
	String email;
	
	Double salario;

	public ListaDetalhesFuncionario( @NotBlank String cpf, @NotBlank String nome, @NotBlank String telefone,@NotBlank @Email String email, Double salario) {
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
}
