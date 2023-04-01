package com.minsait.livraria.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.minsait.livraria.enums.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Livro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String titulo;
	private Integer ano;
	private BigDecimal valorUnitario;
	private BigDecimal valorPromocional;
	private Integer quantidade;
	private Status status;
	
	public Livro(String titulo, int ano, BigDecimal valorUnitario, int quantidade, Status status) {

		this.titulo = titulo;
		this.ano = ano;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		this.status = status;
	}


	public BigDecimal getValorPromocional() {
		return valorPromocional;
	}

	public void setValorPromocional() {
		if (this.valorUnitario != null) {
			this.valorPromocional = this.status.calculaValorPromocional(valorUnitario);
		}
		
	}
	
}
