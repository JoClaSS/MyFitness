package com.br.myfitness.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.myfitness.exception.ExceptionResponse;
import com.br.myfitness.exception.UnsuportedException;

@RestController
@ControllerAdvice
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {
    
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception e, WebRequest req){
    	ExceptionResponse exceptionResponse = new ExceptionResponse(
						new Date(), 
						e.getMessage(), 
						req.getDescription(false));
    	return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(UnsuportedException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception e, WebRequest req){
    	ExceptionResponse exceptionResponse = new ExceptionResponse(
						new Date(), 
						e.getMessage(), 
						req.getDescription(false));
    	return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
