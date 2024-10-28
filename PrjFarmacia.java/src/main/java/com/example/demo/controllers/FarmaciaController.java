package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Medicamento;
import com.example.demo.services.FarmaciaService;

@RestController
@RequestMapping("/medicamentos")
public class FarmaciaController {

	@Autowired
	private FarmaciaService farmaciaService;

	@PostMapping
	public ResponseEntity<Medicamento> salvar(@Validated @RequestBody Medicamento medicamento) {
		Medicamento novoMedicamento = farmaciaService.salvar(medicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoMedicamento);
	}

	@DeleteMapping
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		farmaciaService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<Medicamento> atualizar(@PathVariable Long id,
			@Validated @RequestBody Medicamento medicamento) {
		Medicamento medicamentoAtualizado = farmaciaService.atualizar(id, medicamento);
		return ResponseEntity.ok(medicamentoAtualizado);
	}

	@GetMapping
	public ResponseEntity<List<Medicamento>> consultarTodos() {
		List<Medicamento> medicamentos = farmaciaService.consultarTodos();
		return ResponseEntity.ok(medicamentos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> consultaPorId(@PathVariable Long id) {
		Optional<Medicamento> medicamento = farmaciaService.consultarPorId(id);
		return medicamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

}
