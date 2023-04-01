package com.minsait.livraria.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.livraria.entity.Livro;
import com.minsait.livraria.exception.LivroNotFoundException;
import com.minsait.livraria.repository.LivroRepository;

@Service
public class LivroService {

	private LivroRepository livroRepository;

	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro cadastrarLivro(Livro livro) {
		livro.setValorPromocional();
		return this.livroRepository.save(livro);
	}

	public Livro recuperarLivro(Long id) {
		return this.livroRepository.getReferenceById(id);
	}

	public List<Livro> recuperarTodosLivros() {
		return this.livroRepository.findAll();
	}

	public Livro alterarLivro(@Valid Livro livro, Long id) throws LivroNotFoundException {

		if (this.livroRepository.existsById(id)) {
			Livro LivroASerAlterado = this.livroRepository.findById(id).get();
						
			livro.setId(id);
									
			if (livro.getQuantidade() == null) {
				livro.setQuantidade(LivroASerAlterado.getQuantidade());
			}
			
			if (livro.getAno() == null) {
				livro.setAno(LivroASerAlterado.getAno());
			}
			
			return this.livroRepository.save(livro);			

		}

		throw new LivroNotFoundException(id);

	}
		
	public MensagemDeSucesso deletarLivro(Long id) throws LivroNotFoundException {

		if (this.livroRepository.existsById(id)) {
			this.livroRepository.deleteById(id);
			MensagemDeSucesso mensagem = new MensagemDeSucesso();
			mensagem.setMensagem("Deletado com sucesso");
			return mensagem;

		}

		throw new LivroNotFoundException(id);
	}

}
