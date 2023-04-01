package com.minsait.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.livraria.dto.LivroDTO;
import com.minsait.livraria.entity.Livro;
import com.minsait.livraria.exception.LivroNotFoundException;
import com.minsait.livraria.service.LivroService;
import com.minsait.livraria.service.MensagemDeSucesso;

@RestController
@RequestMapping("/api/v1/livraria/livros")
public class LivroController {
	
	private LivroService livroService;
	
	@Autowired
	public LivroController(LivroService livroService) {		
		this.livroService = livroService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro cadastrarLivro(@Valid @RequestBody Livro livro) {
		Livro livroSalvo = this.livroService.cadastrarLivro(livro);
		return livroSalvo;
	}
	
	@GetMapping
	public List<Livro> recuperarTodosLivros() {
		List<Livro> retorno = this.livroService.recuperarTodosLivros();
		return retorno;	
	}
	
	@GetMapping("/{id}")
	public Livro recuperarLivro(@PathVariable Long id)
			throws LivroNotFoundException{
		
		Livro livroRecuperado = this.livroService.recuperarLivro(id);
		return livroRecuperado;		
	}
	
	@PutMapping("/{id}")
	public LivroDTO alterarLivro(@PathVariable Long id, @Valid @RequestBody LivroDTO livro)
			throws LivroNotFoundException {
		
		Livro livroRequest = LivroDTO.retornaLivro(livro);

		Livro livroAlterado = this.livroService.alterarLivro(livroRequest, id);
		
		return LivroDTO.retornaLivro(livroAlterado);		
	}
		
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public MensagemDeSucesso deletarLivro(@PathVariable Long id) 
			throws LivroNotFoundException {
		
		return this.livroService.deletarLivro(id);		
	}
	
			
}
