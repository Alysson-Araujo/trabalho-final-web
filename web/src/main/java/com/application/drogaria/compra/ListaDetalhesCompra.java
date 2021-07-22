package com.application.drogaria.compra;

import java.time.LocalDateTime;

public class ListaDetalhesCompra {

	private String cpfCliente;
	
	private String cpfFuncionario;
	
	private double preco;
	
	private double desconto;
	
	private LocalDateTime data;

	public ListaDetalhesCompra(String cpfCliente, String cpfFuncionario, double preco, double desconto,
			LocalDateTime data) {
		super();
		this.cpfCliente = cpfCliente;
		this.cpfFuncionario = cpfFuncionario;
		this.preco = preco;
		this.desconto = desconto;
		this.data = data;
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

	public LocalDateTime getData() {
		return data;
	}
}
