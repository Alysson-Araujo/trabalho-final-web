package com.application.drogaria.cliente;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping(value="/cliente")
	public ResponseEntity<Object> getClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		
		if(clientes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(clientes);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(clientes);
		}
	}
	
	@GetMapping(value="/cliente/{id}")
	public ResponseEntity<Object> getCliente(@Valid @PathVariable @NotNull long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(cliente);
		}
	}
	
	@PostMapping(value="/cliente")
	@Transactional
	public ResponseEntity<Object> addCliente(@RequestBody @Valid AdicionaClienteRequest novoCliente) {
		boolean existsCliente = clienteRepository.existsByEmail(novoCliente.getEmail());
		if(existsCliente) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Cliente existente");
		} else {
			System.out.println("Entrou");
			Cliente cliente = novoCliente.toModel();
			clienteRepository.save(cliente);
			System.out.println("Funcionou");
			return ResponseEntity.status(HttpStatus.CREATED).body("Ok");
		}
	}
	
	@PutMapping(value="/cliente/{id}")
	@Transactional
	public ResponseEntity<Object> alteraCliente(@Valid @PathVariable @NotNull long id, @RequestBody AlteraClienteRequest clienteAlterado) {
		Optional<Cliente> clienteOpt = clienteRepository.findById(id);
		
		if(clienteOpt.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
		} else {
			clienteAlterado.alteraDados(clienteOpt.get());
			System.out.println(clienteAlterado.getNome());
			return ResponseEntity.status(HttpStatus.OK).body("Cliente alterado com sucesso");
		}
	}
	
	@DeleteMapping(value="/cliente/{id}")
	@Transactional
	public ResponseEntity<Object> deleteCliente(@Valid @PathVariable @NotNull long id) {
		Optional<Cliente> clienteOpt = clienteRepository.findById(id);
		
		if(clienteOpt.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
		} else {
			Cliente cliente = clienteOpt.get();
			clienteRepository.delete(cliente);
			return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
		}
	}
}
