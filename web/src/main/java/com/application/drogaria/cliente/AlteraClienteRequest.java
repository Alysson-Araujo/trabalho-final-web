package com.application.drogaria.cliente;

public class AlteraClienteRequest {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String alergia;
    private double desconto;
	
	@Deprecated
	public AlteraClienteRequest() {
		super();
		this.nome = "";
		this.cpf = "";
		this.telefone = "";
		this.email = "";
		this.alergia = "";
		this.desconto = 0;
	}
	
	public AlteraClienteRequest(String nome, String cpf, String telefone,
			String email, String alergia, double desconto) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.alergia = alergia;
		this.desconto = desconto;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getAlergia() {
		return alergia;
	}

	public double getDesconto() {
		return desconto;
	}
	
	public void alteraDados(Cliente cliente) {
		if(!nome.isEmpty()) {
			cliente.setNome(nome);
		}
		if(!telefone.isEmpty()) {
			cliente.setTelefone(telefone);
		}
		if(!email.isEmpty()) {
			cliente.setEmail(email);
		}
		if(!alergia.isEmpty()) {
			cliente.setAlergia(alergia);
		}
		if(desconto >= 0) {
			cliente.setDesconto(desconto);
		}
	}
}
