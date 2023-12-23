package com.br.myfitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Perfil")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Perfil {

	
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "perfil_sequence", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;
	@Column
	private String nome;
	@Column
	private String apelido;
	@Column
	private int idade;
	@Column
	private String sexo;
	@Column
	private String email;
	@Column
	private double peso;
	@Column
	private double altura;
	@Column 
	private Boolean professor;
	@Column 
	private Boolean ativo;
	@OneToOne
	@JsonIgnore
	private Usuario usuario;
}
