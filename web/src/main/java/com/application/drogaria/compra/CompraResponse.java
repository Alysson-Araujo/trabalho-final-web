package com.application.drogaria.compra;

import java.time.LocalDateTime;

public class CompraResponse {
	long id;
	String cpfCliente;
	double preco;
	LocalDateTime data;
	
	public CompraResponse(long id, String cpfCliente, double preco, LocalDateTime data) {
		super();
		this.id = id;
		this.cpfCliente = cpfCliente;
		this.preco = preco;
		this.data = data;
	}
	public long getId() {
		return id;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public double getPreco() {
		return preco;
	}
	public LocalDateTime getData() {
		return data;
	}
	
	

}
