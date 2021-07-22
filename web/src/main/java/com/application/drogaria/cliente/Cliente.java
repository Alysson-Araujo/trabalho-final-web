package com.application.drogaria.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Cliente {
	@Id
	@GeneratedValue
	private long id;
	
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
	public Cliente() {}

	public Cliente(@Size(max = 100) @NotBlank String nome, @NotBlank String cpf, String telefone,
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
}
