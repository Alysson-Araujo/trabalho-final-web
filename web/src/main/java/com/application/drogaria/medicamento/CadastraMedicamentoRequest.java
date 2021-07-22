package com.application.drogaria.medicamento;

import java.time.LocalDateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class CadastraMedicamentoRequest {
	@NotBlank
	private String nome;
	
	@NotNull
	@FutureOrPresent
	private LocalDateTime validade;
	
	@NotNull
	private double preco;
	
	@Deprecated
	public CadastraMedicamentoRequest() {}
	
	public CadastraMedicamentoRequest(@NotBlank String nome,@NotNull @FutureOrPresent LocalDateTime validade,
			@NotNull double preco) {
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Medicamento toModel() {
		return new Medicamento(this.nome, this.validade, this.preco);
		
	}
}













