package com.application.drogaria.medicamento;

import java.time.LocalDateTime;

public class MedicamentoAltera {
	private long id;
	private String nome;
	private LocalDateTime validade;
	private double preco;
	
	@Deprecated
	public MedicamentoAltera() {
		super();
		this.id = 0;
		this.nome = "";
		this.validade = null;
		this.preco = 0.0;
	}

	public MedicamentoAltera(long id, String nome, LocalDateTime validade, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.validade = validade;
		this.preco = preco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void alteraMedicamento(Medicamento medicamento) {
		if(preco > 0) {
			medicamento.setPreco(preco);
		}
		
	}
	
}
