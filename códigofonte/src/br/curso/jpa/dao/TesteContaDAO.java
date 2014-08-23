package br.curso.jpa.dao;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.curso.jpa.bean.Conta;
import br.curso.jpa.utils.JPAUtil;

public class TesteContaDAO {

		@Test
		public void deveCadastrarConta() {
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			
			ContaDAO contaDAO = new ContaDAO(em);
			Conta conta = new Conta();
			
			conta.setTitular("Carol");
			conta.setSaldo(1500d);
			
			contaDAO.cadastrar(conta);
			
			Assert.assertNotNull(conta.getId());
			
			em.getTransaction().commit();
			em.close();
		}

}
