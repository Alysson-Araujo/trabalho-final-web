package com.application.drogaria.medicamento;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@NotBlank
	public String nome;
	
	@NotNull
	@FutureOrPresent
	public LocalDateTime validade;
	
	
	@NotNull
	public double preco;
	
	@Deprecated
	public Medicamento() {}
	
	public Medicamento(@NotBlank String nome, @NotNull @FutureOrPresent LocalDateTime validade,
			@NotNull double preco) {
		super();
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
}
