package br.curso.jpa.testes;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.curso.jpa.bean.Conta;
import br.curso.jpa.bean.Movimentacao;
import br.curso.jpa.dao.ContaDAO;
import br.curso.jpa.utils.JPAUtil;

public class TesteBiderecional {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		ContaDAO contaDAO = new ContaDAO(em);
		List<Movimentacao> listaMovimentacoes;

		Conta conta = new Conta();
		
		conta = contaDAO.consultar(4L);
		listaMovimentacoes = conta.getListaDeMovimentacoes();
		
		for(Movimentacao movimentacaoEach : listaMovimentacoes) {
			System.out.println("Descrição: " + movimentacaoEach.getDescricao());
			System.out.println("Valor: R$" + movimentacaoEach.getValor());
			System.out.println("Tipo: " + movimentacaoEach.getTipo());
			System.out.println("Data: " + movimentacaoEach.getData().get(Calendar.DAY_OF_MONTH) + 
					"/" + (movimentacaoEach.getData().get(Calendar.MONTH) + 1) + 
					"/" + movimentacaoEach.getData().get(Calendar.YEAR) + "\n");
		}
	}

}
