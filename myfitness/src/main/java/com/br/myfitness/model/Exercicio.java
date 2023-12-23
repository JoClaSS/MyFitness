package com.br.myfitness.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "exercicio")
public class Exercicio {
	
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "exercicio_sequence", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;
	@Column
	private int ordemExecucao;
	@Column
	private String descricao;
	@Column
	private String grupamentoMuscular;
	@Column
	private int carga;
	@Column
	private int series;
	@Column
	private int repeticoes;
	@Column
	private String observacao;
	@JsonIgnore
	@ManyToOne
	private Treino treino;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date dataCriacao;


}
