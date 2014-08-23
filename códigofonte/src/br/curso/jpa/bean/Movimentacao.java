package br.curso.jpa.bean;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.curso.jpa.enums.TipoMovimentacaoEnum;

@Entity
public class Movimentacao {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Conta conta;
	private String descricao;
	private Calendar data;
	private Double valor;
	
	@Enumerated (EnumType.STRING)
	private TipoMovimentacaoEnum tipo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public TipoMovimentacaoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimentacaoEnum tipo) {
		this.tipo = tipo;
	}
	
}
