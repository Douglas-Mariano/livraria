package com.minsait.livraria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.minsait.livraria.entity.Livro;
import com.minsait.livraria.repository.LivroRepository;

@Service
public class LivroService {

	private LivroRepository livroRepository;
	
	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public Livro cadastrarLivro(Livro livro) {
		return livroRepository.save(livro);
	}

	public List<Livro> listarLivro() {
		return livroRepository.findAll();
	}
	
	public ResponseEntity<Livro> buscarId (Long id) {
		return livroRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<String> deletarLivro(Long id) {
		livroRepository.deleteById(id);
		return new ResponseEntity<String>("Deletado", HttpStatus.OK);
	}
	
}
