package com.application.drogaria.compra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.drogaria.funcionario.Funcionario;


public interface CompraRepositoryFuncionario extends JpaRepository<Funcionario, Long> {
	
	public boolean existsByCpf(String cpf);
	
}
