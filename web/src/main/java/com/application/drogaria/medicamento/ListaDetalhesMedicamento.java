package com.application.drogaria.medicamento;

import java.time.LocalDateTime;

public class ListaDetalhesMedicamento {

	String nome;
	LocalDateTime validade;
	Double  preco;
	
	public ListaDetalhesMedicamento(String nome, LocalDateTime validade, Double preco) {
		super();
		this.nome = nome;
		this.validade = validade;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getValidade() {
		return validade;
	}

	public void setValidade(LocalDateTime validade) {
		this.validade = validade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
