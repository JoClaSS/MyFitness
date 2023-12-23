package com.br.myfitness.model;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "treino")
public class Treino {
	
	@Id
	@SequenceGenerator(name = "seqTreino", sequenceName = "treino_sequence", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;
	@Column
	private String titulo;
	@Column
	private Date dataInicio;
	@Column
	private Date dataFim;
	@Column
	private String objetivo;
	@OneToOne
	private Perfil aluno;
	@OneToOne
	private Perfil professor;
	@Column
	private DayOfWeek diasSemana;
	@Column 
	private Boolean ativo;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date dataCriacao;

}
