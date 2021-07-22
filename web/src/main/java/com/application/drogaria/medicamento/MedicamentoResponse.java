package com.application.drogaria.medicamento;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class MedicamentoResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@NotBlank
	public String nome;
	
	@NotNull
	@FutureOrPresent
	public LocalDateTime validade;
	
	@NotNull
	public Double preco;

	public MedicamentoResponse(long id, @NotBlank String nome, @NotBlank @FutureOrPresent LocalDateTime validade,
			@NotNull Double preco) {
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
