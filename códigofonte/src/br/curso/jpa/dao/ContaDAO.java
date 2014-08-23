package br.curso.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.curso.jpa.bean.Conta;

public class ContaDAO {
	private GenericDAO<Conta> dao;
	
	public ContaDAO(EntityManager em) {
		dao = new GenericDAO<Conta>(em, Conta.class);
	}
	
	public void excluir(Conta t) {
		dao.excluir(t);
	}

	public Conta consultar(Long id) {
		return dao.consultar(id);
	}

	public List<Conta> listar() {
		return dao.listar();
	}

	public void cadastrar(Conta conta) {
		dao.cadastrar(conta);
	}
	
}
