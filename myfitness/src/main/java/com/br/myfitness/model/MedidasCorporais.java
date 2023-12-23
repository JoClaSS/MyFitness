package com.br.myfitness.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "medidas_corporais")
public class MedidasCorporais {
	
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "medidas_sequence", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;
	@Column
	private String descricao; 
	@Column
	private double valor;
	@Column 
	private Boolean ativo;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date dataCriacao;
	@ManyToOne
	private Perfil perfil;
	

}
