package br.curso.jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.curso.jpa.vo.ValorPorMes;
import br.curso.jpa.bean.Conta;
import br.curso.jpa.bean.Movimentacao;
import br.curso.jpa.enums.TipoMovimentacaoEnum;
import br.curso.jpa.utils.JPAUtil;

public class MovimentacaoDAO {
	private GenericDAO<Movimentacao> dao;
	private EntityManager em = JPAUtil.getEntityManager();
	
	public MovimentacaoDAO(EntityManager em) {
		dao = new GenericDAO<Movimentacao>(em, Movimentacao.class);
	}
	
	public void excluir(Movimentacao t) {
		dao.excluir(t);
	}

	public Movimentacao consultar(Long id) {
		return dao.consultar(id);
	}

	public List<Movimentacao> listar() {
		return dao.listar();
	}

	public void cadastrar(Movimentacao Movimentacao) {
		dao.cadastrar(Movimentacao);
	}
	
	public List<Movimentacao> filtrar(Conta conta) {
		String jpql = "Select m from Movimentacao m where m.conta = :pConta";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		return query.getResultList();
	}
	
	public List<Movimentacao> filtrar(Conta conta, TipoMovimentacaoEnum tipo) {
		String jpql = "Select m from Movimentacao m where m.conta = :pConta and tipo = pTipo";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		return query.getResultList();
	}
	
	public BigDecimal soma (Conta conta, TipoMovimentacaoEnum tipo) {
		String jpql = "Select sum(m.valor) from Movimentacao m where m.conta = :pConta and tipo = pTipo";
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		return query.getSingleResult();
	}
	
	public List<ValorPorMes> valorPorMes (Conta conta, TipoMovimentacaoEnum tipo) {
		String jpql = "Select new br.com.curso.jpa.vo.ValorPorMes(month(m.data), sum(m.valor)"
				+ " from Movimentacao m "
				+ "group by month(m.data), m.conta, .tipo "
				+ "having m.conta = :pConta and tipo = pTipo";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		
		return query.getResultList();
	}
}
