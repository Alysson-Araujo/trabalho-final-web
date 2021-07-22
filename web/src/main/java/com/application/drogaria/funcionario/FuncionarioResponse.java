package com.application.drogaria.funcionario;

public class FuncionarioResponse {
	
	long id;
	
	String nome;

	public FuncionarioResponse(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
