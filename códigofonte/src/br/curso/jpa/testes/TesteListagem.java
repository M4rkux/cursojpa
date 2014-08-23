package br.curso.jpa.testes;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.curso.jpa.bean.Conta;
import br.curso.jpa.bean.Movimentacao;
import br.curso.jpa.dao.ContaDAO;
import br.curso.jpa.dao.MovimentacaoDAO;
import br.curso.jpa.utils.JPAUtil;

public class TesteListagem {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Conta conta = new Conta();
		ContaDAO contaDAO = new ContaDAO(em);
		Movimentacao movimentacao = new Movimentacao();
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(em);
		List<Movimentacao> movimentacoes;
		
		em.getTransaction().begin();
		conta = contaDAO.consultar(4L);

		movimentacoes = movimentacaoDAO.filtrar(conta);
		
		System.out.println(" --- Todos da conta "+ conta.getTitular() +" ---");
		for(Movimentacao movimentacaoEach : movimentacoes) {
			System.out.println("ID: " + movimentacaoEach.getId());
			System.out.println("Descrição: " + movimentacaoEach.getDescricao());
			System.out.println("Valor: R$" + movimentacaoEach.getValor());
			System.out.println("Tipo: " + movimentacaoEach.getTipo());
			System.out.println("Data: " + movimentacaoEach.getData().get(Calendar.DAY_OF_MONTH) + 
									"/" + (movimentacaoEach.getData().get(Calendar.MONTH) + 1) + 
									"/" + movimentacaoEach.getData().get(Calendar.YEAR) + "\n");
		}
		
		
		em.getTransaction().commit();
		em.close();
		
		
	}
}
