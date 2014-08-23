package br.com.curso.jpa.vo;

import java.math.BigDecimal;

public class ValorPorMes {
	private int mes;
	private BigDecimal valor;
	
	public ValorPorMes(int month, BigDecimal valor) {
		super();
		this.mes = month;
		this.valor = valor;
	}
	
	public int getMonth() {
		return mes;
	}
	public void setMonth(int month) {
		this.mes = month;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
