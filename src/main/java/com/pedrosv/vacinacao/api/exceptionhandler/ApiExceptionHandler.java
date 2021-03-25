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
		
		var boddyError = new BoddyError();
		boddyError.setStatus(status.value());
		boddyError.setTitulo(ex.getMessage());
		boddyError.setDataHora(LocalDateTime.now());
		
		return super.handleExceptionInternal(ex, boddyError, new HttpHeaders(), status, request); 
		
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var boddyError = new BoddyError();
		boddyError.setStatus(status.value());
		boddyError.setTitulo("Um ou mais campos inválidos");
		boddyError.setDataHora(LocalDateTime.now());
		
		return super.handleExceptionInternal(ex, boddyError, headers, status, request);
	}

}
