package com.br.myfitness.exception;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import lombok.Getter;


@Getter
@Entity
public class ExceptionResponse implements Serializable {
	
	//precisei criar, pois AllArgsConstreuctor não funcionou
	public ExceptionResponse(Date timestamp, String message, String details) {
	}
	
	private Date timestamp;
	private String message;
	private String details;

}
