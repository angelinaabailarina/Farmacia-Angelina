package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Medicamento;
import com.example.demo.repositorys.FarmaciaRepository;

@Service
public class FarmaciaService {
	
	@Autowired
	private FarmaciaRepository farmaciaRepository;
	
	public Medicamento salvar(Medicamento medicamento) {
		return farmaciaRepository.save(medicamento);
	}
	public void deletar(Long id) {
		farmaciaRepository.deleteById(id);
	}
	public Medicamento atualizar(Long id, Medicamento medicamento) {
		medicamento.setId(id);
		return farmaciaRepository.save(medicamento);
	}
	public List<Medicamento> consultarTodos(){
		return farmaciaRepository.findAll();
	}
	public Optional<Medicamento> consultarPorId(Long id){
		return farmaciaRepository.findById(id);
	}
	

}
