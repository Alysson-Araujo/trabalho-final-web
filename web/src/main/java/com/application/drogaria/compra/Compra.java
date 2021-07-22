package com.application.drogaria.compra;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.sun.istack.NotNull;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotBlank
	private String cpfCliente;
	
	@NotBlank
	private String cpfFuncionario;
	
	@NotNull
	private double preco;
	
	private double desconto;
	
	@PastOrPresent
	private LocalDateTime data = LocalDateTime.now();
	
	@Deprecated
	public Compra() {
		this.desconto = 0.0;
	}

	public Compra(@NotBlank String cpfCliente, @NotBlank String cpfFuncionario, double preco, double desconto) {
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

	public LocalDateTime getData() {
		return data;
	}
}
