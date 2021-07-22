package com.application.drogaria.compra;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class CompraTemp {
	
	@NotBlank
	private String cpfCliente;
	
	@NotBlank
	private String cpfFuncionario;
	
	@NotNull
	private double preco;
	
	private double desconto;
	

	public CompraTemp(@NotBlank String cpfCliente, @NotBlank String cpfFuncionario, double preco, double desconto) {
		super();
		this.cpfCliente = cpfCliente;
		this.cpfFuncionario = cpfFuncionario;
		this.preco = preco;
		this.desconto = desconto;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public double getPreco() {
		return preco;
	}

	public double getDesconto() {
		return desconto;
	}

	public Compra toModel() {
		return new Compra(this.cpfCliente, this.cpfFuncionario, this.preco, this.desconto);
	}
}
