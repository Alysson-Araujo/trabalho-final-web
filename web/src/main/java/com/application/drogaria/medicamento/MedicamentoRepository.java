package com.application.drogaria.medicamento;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{
	
	public Optional<Medicamento> findByNome(String nome);
	
	public boolean existsByNome(String nome);
	
}
