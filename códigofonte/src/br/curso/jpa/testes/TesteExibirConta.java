package br.curso.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.curso.jpa.bean.Conta;
import br.curso.jpa.dao.ContaDAO;
import br.curso.jpa.utils.JPAUtil;


public class TesteExibirConta {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Conta conta = new Conta();
		ContaDAO contaDAO = new ContaDAO(em);
		
		em.getTransaction().begin();
		conta.setTitular(contaDAO.consultar(2L).getTitular());
		conta.setSaldo(contaDAO.consultar(2L).getSaldo());
		
		List<Conta> contas = contaDAO.listar();
		
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Titular: " + conta.getTitular());
		System.out.println("Saldo: " + conta.getSaldo());
		
		System.out.println(" --- Todos ---");
		for(Conta contaEach : contas) {
			System.out.println("ID: " + contaEach.getId());
			System.out.println("Titular: " + contaEach.getTitular());
			System.out.println("Saldo: " + contaEach.getSaldo() + "\n");
		}
	}

}
