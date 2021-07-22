package com.application.drogaria.medicamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicamentoController {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	MedicamentoRepository medicamentoRepository;
	
	@PostMapping(value = "/medicamento")
	@Transactional
	public ResponseEntity<Object> addMedicamento(@RequestBody @Valid CadastraMedicamentoRequest cadastraMedicamentoRequest) { 
		
		boolean existsMedicamento = medicamentoRepository.existsByNome(cadastraMedicamentoRequest.getNome());
		
		if(existsMedicamento) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Medicamento já existe");
		}
		
		//System.out.println("Id: " + cadastraMedicamentoRequest.getId());
		//System.out.println("Nome: " + cadastraMedicamentoRequest.getNome());
		//System.out.println("Validade: " + cadastraMedicamentoRequest.getValidade());
		//System.out.println("Preço: " + cadastraMedicamentoRequest.getPreco());
		
		Medicamento medicamento = cadastraMedicamentoRequest.toModel();
 		medicamentoRepository.save(medicamento);
 		return ResponseEntity.created(null).body("Medicamento inserido com sucesso");
 	}
	
	@DeleteMapping(value ="/medicamento/{nomeMedicamento}")
	@Transactional
	public ResponseEntity<Object> delMedicamento(@Valid @NotBlank @PathVariable Long nomeMedicamento) {
		Optional<Medicamento> medicamentoOpt = medicamentoRepository.findById(nomeMedicamento);
		if(medicamentoOpt.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicamento não existe");
		}
		Medicamento medicamentoFromDb = medicamentoOpt.get();
		medicamentoRepository.delete(medicamentoFromDb);
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
		
	}
	
	@GetMapping(value = "/medicamento")
	@Transactional
	public List<MedicamentoResponse> listaMedicamentos(){
		
		List<MedicamentoResponse> medicamentosResponse = new ArrayList<>();
		List<Medicamento> medicamentosFromDb = medicamentoRepository.findAll();
		
		medicamentoRepository.findAll();
		if(medicamentosFromDb.isEmpty()) {
			return null;
		}
		
		for (Medicamento medicamento : medicamentosFromDb) {
			
			medicamentosResponse.add(new MedicamentoResponse(medicamento.id, medicamento.nome, medicamento.validade, medicamento.preco));
					
		}
		
		return medicamentosResponse;
	}
	
	@GetMapping(value = "/medicamento/{idMedicamento}")
	@Transactional
	public ResponseEntity<Object> listaDetalhesMedicamento(@Valid @NotNull @PathVariable long idMedicamento) {
		Optional<Medicamento> medicamentoOpt = medicamentoRepository.findById(idMedicamento);
		if(medicamentoOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
			
		}
		Medicamento medicamentoFromDb = medicamentoOpt.get();
		
		ListaDetalhesMedicamento detalhesMedicamento = new ListaDetalhesMedicamento(medicamentoFromDb.nome, medicamentoFromDb.validade, medicamentoFromDb.preco);
		
		return ResponseEntity.ok(detalhesMedicamento);
	}
	
	@PutMapping(value = ("/medicamento"))
	@Transactional
	public ResponseEntity<Object> alteraPrecoMedicamento(@Valid @NotNull @PathVariable  long idMedicamento, @RequestBody MedicamentoAltera medicamentoAltera){
		Optional<Medicamento> medicamentoOpt = medicamentoRepository.findById(idMedicamento);
		if(medicamentoOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else{medicamentoAltera.alteraMedicamento(medicamentoOpt.get());
		
			return ResponseEntity.status(HttpStatus.OK).body("preço de medicamento alterado com sucesso");
		}
	}
}