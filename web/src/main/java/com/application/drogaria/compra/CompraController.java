package com.application.drogaria.compra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;


@RestController
public class CompraController {
	
	@Autowired
	CompraRepository compraRepository;
	
	
	@Autowired
	CompraRepositoryFuncionario compraRepositoryFuncionario;
	
	@Autowired
	CompraRepositoryCliente compraRepositoryCliente;
	
	@PostMapping(value = "/compra")
	@Transactional
	
	public ResponseEntity<Object> addcompra(@RequestBody @Valid CompraTemp compraTemp) {
			
		boolean existeCpfCFuncionario = compraRepositoryFuncionario.existsByCpf(compraTemp.getCpfFuncionario());
		boolean existeCpfCliente = compraRepositoryCliente.existsByCpf(compraTemp.getCpfCliente());
		

		if(!existeCpfCFuncionario) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF do Funcionario não encontrado");
		}
		
	if(!existeCpfCliente) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF do cliente não encontrado");
	}
			
		
			
		Compra compra = compraTemp.toModel();
			
		compraRepository.save(compra);
			
		return ResponseEntity.created(null).body("compra cadastrada com sucesso");
			
			
	}
	
	@GetMapping(value = "/compra")
	public List<CompraResponse> listaCompra(){
		
		List<CompraResponse> compraResponse = new ArrayList<>();
		
		List<Compra> compraFromDb = compraRepository.findAll();
		
		if (compraFromDb.isEmpty()) {
			return null;
		}
		
		for (Compra compra : compraFromDb) {
			compraResponse.add(new CompraResponse(compra.id, compra.getCpfCliente(), compra.getPreco(), compra.getData() ));
		}
		
		return compraResponse;
	}
	
	
	@GetMapping(value = "/compra/{idCompra}")
	public ResponseEntity<Object> listaDetalhesCompra(@Valid @NotNull @PathVariable long idCompra) {
		
		Optional<Compra> compraOpt = compraRepository.findById(idCompra);
		
		if(compraOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Compra compraFromDB = compraOpt.get();
		
		ListaDetalhesCompra detalhesCompra = new ListaDetalhesCompra(compraFromDB.getCpfCliente(), compraFromDB.getCpfFuncionario(), compraFromDB.getPreco(), compraFromDB.getDesconto(), compraFromDB.getData() );
		
		return ResponseEntity.ok(detalhesCompra);
		
		
	}
	
	@DeleteMapping(value = "/compra/{idCompra}")
	public ResponseEntity<Object> removeCompra(@Valid @NotNull @PathVariable long idCompra) {
		
		Optional<Compra> compraOpt = compraRepository.findById(idCompra);
		
		if(compraOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Compra compraFromDB = compraOpt.get();
		
		compraRepository.delete(compraFromDB);
		
		return ResponseEntity.ok().body("deletado com sucesso");
		
		
	}
		

}
