package com.minsait.livraria.enums;

import java.math.BigDecimal;
import java.math.MathContext;

public enum Status {
	
	Lancamento(1) {
		@Override
		public BigDecimal calculaValorPromocional(BigDecimal valorAtual) {
			BigDecimal fatorMultiplicador = new BigDecimal(1.5);
			return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
		}
	},
	 
    Saldao(2) {
		@Override
		public BigDecimal calculaValorPromocional(BigDecimal valorAtual) {
			BigDecimal fatorMultiplicador = new BigDecimal(0.5);
			return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
					
		}
	},
 
    Normal(3) {
		@Override
		public BigDecimal calculaValorPromocional(BigDecimal valorAtual) {
			BigDecimal fatorMultiplicador = new BigDecimal(1.0);
			return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
		}
	};
 
    private int codigo;
 
    private Status(int codigo) {
 
        this.codigo = codigo;
    }
 
    public int getCodigo() { 
        return this.codigo;
    }
    
    public abstract BigDecimal calculaValorPromocional(BigDecimal valorAtual);

}
