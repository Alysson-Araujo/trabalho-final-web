package com.application.drogaria.compra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.drogaria.cliente.Cliente;


public interface CompraRepositoryCliente extends JpaRepository<Cliente, Long> {
	
	public boolean existsByCpf(String cpf);

	
}
