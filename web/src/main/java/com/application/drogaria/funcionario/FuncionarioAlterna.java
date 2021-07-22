package com.application.drogaria.funcionario;


public class FuncionarioAlterna {

	 private String cpf;
	
	 private String nome;
	
	 private String telefone;
	
	 private String email;
	
	 Double salario;
	
	@Deprecated
	public FuncionarioAlterna() {
		super();
		this.cpf="";
		this.nome = "";
		this.telefone = "";
		this.email = "";
		this.salario = 0.0;
	}
	
	public FuncionarioAlterna(String cpf, String nome, String telefone, String email, Double salario) {
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

	public void alteraDados(Funcionario funcionario) {
		if(!nome.isEmpty()) {
			funcionario.setNome(nome);
		}
		if(!telefone.isEmpty()) {
			funcionario.setTelefone(telefone);
		}
		if(!email.isEmpty()) {
			funcionario.setEmail(email);
		}
		if(salario > 0) {
			funcionario.setSalario(salario);
		}
	}
}
	
