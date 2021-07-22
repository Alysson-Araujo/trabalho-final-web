package com.application.drogaria.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	boolean existsByCpf(String cpf);
	
}
