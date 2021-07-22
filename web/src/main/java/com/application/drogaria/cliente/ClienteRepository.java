package com.application.drogaria.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public boolean existsByEmail(String email);
	
}
