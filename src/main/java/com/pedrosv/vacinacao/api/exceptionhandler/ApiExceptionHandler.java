package com.pedrosv.vacinacao.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pedrosv.vacinacao.domain.exception.DomainException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<Object> handleDomainException(DomainException ex, WebRequest request) {
		
		var status = HttpStatus.BAD_REQUEST;
		
		var bodyError = new BodyError();
		bodyError.setStatus(status.value());
		bodyError.setTitulo(ex.getMessage());
		bodyError.setDataHora(LocalDateTime.now());
		
		return super.handleExceptionInternal(ex, bodyError, new HttpHeaders(), status, request); 
		
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var bodyError = new BodyError();
		bodyError.setStatus(status.value());
		bodyError.setTitulo("Um ou mais campos inválidos");
		bodyError.setDataHora(LocalDateTime.now());
		
		return super.handleExceptionInternal(ex, bodyError, headers, status, request);
	}

}
