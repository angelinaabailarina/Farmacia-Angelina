package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Medicamento;

@Repository
public interface FarmaciaRepository extends JpaRepository<Medicamento, Long>{

}
