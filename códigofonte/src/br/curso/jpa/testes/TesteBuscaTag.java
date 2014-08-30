package br.curso.jpa.testes;

import javax.persistence.EntityManager;

import br.curso.jpa.bean.Tag;
import br.curso.jpa.dao.TagDAO;
import br.curso.jpa.utils.JPAUtil;

public class TesteBuscaTag {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		TagDAO tagDAO = new TagDAO(em);
		Tag tag = tagDAO.adicionarOuBuscarTag("tag2");
		
		System.out.println( tag.getId() + " - " + tag.getNome());
		
		em.getTransaction().commit();
		em.close();
	}

}
