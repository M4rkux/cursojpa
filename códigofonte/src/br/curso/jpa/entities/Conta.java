package br.curso.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {
	@Id
	@GeneratedValue
	private Long Id;
	private String titular;
	private Double saldo;
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
