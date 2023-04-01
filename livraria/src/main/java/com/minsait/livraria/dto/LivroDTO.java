package com.minsait.livraria.dto;

import java.math.BigDecimal;

import com.minsait.livraria.entity.Livro;
import com.minsait.livraria.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDTO {
	
	private String titulo;
	private Integer ano;
	private BigDecimal valorUnitario;
	private Integer quantidade;
	private Status status;
	
	public LivroDTO() {
		
	}
	
	public static LivroDTO retornaLivro(Livro livro) {
		LivroDTO livroDTO = new LivroDTO(livro.getTitulo(), livro.getAno(), livro.getValorUnitario(), livro.getQuantidade(), livro.getStatus());
		return livroDTO;
		
	}
	
	public static Livro retornaLivro(LivroDTO livroDTO) {
		Livro livro = new Livro(livroDTO.getTitulo(), livroDTO.getAno(), livroDTO.valorUnitario, livroDTO.getQuantidade(), livroDTO.getStatus());
		return livro;
		
	}
	
	public LivroDTO(String titulo, int ano, BigDecimal valorUnitario, int quantidade, Status status) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		this.status = status;
	}


}
