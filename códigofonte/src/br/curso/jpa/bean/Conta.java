package br.curso.jpa.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {
	@Id
	@GeneratedValue
	private Long Id;
	private String titular;
	private Double saldo;
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> listaDeMovimentacoes = new ArrayList<Movimentacao>();
	
	public List<Movimentacao> getListaDeMovimentacoes() {
		return listaDeMovimentacoes;
	}
	public void setListaDeMovimentacoes(List<Movimentacao> listaDeMovimentacoes) {
		this.listaDeMovimentacoes = listaDeMovimentacoes;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}
