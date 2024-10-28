package com.example.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(max = 100, message = "O nome não pode ter mais de 100 caracteres") private String nome;
	
	@Size(max = 500, message = "A bula não pode ter mais de 500 caracteres") private String bula;
	
	@NotNull(message = "O campo precisa ser preenchido") private int attribute12;
	
	@NotNull(message = "Data de validade é obrigatória") private String dataValidade;
	
	
	public Long getId() {
	       return id;
	   }
	   public void setId(Long id) {
	       this.id = id;
	   }
	 public String getNome() {
	       return nome;
	   }
	   public void setNome(String nome) {
	       this.nome = nome;
	   }
	   public String getBula() {
	       return bula;
	   }
	   
	   public void setBula(String bula) {
	       this.bula = bula;
	   }
	   public int getAttribute12() {
	       return attribute12;
	   }
	   
	   public void setAttribute12(int attribute12) {
	       this.attribute12 = attribute12;
	   }
	   public String getDataValidade() {
	       return dataValidade;
	   }
	   
	   public void setDataValidade(String dataValidade) {
	       this.dataValidade = dataValidade;
	   }

}
