package com.application.drogaria.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdicionaClienteRequest {
	@Size(max=100)
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	private String telefone;
	
	@Email
	private String email;
	
    @NotBlank
	private String alergia;
    
    private double desconto;
	
	@Deprecated
	public AdicionaClienteRequest() {}

	public AdicionaClienteRequest(@Size(max = 100) @NotBlank String nome, @NotBlank String cpf, String telefone,
			@Email String email, @NotBlank String alergia, double desconto) {
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
	
	public Cliente toModel() {
		return new Cliente(nome, cpf, telefone, email, alergia, desconto);
	}
}
