package com.minsait.livraria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LivroNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public LivroNotFoundException(Long id) {		
		super(String.format("Livro com id %s nao encontrado", id));			
	}	
	
}
