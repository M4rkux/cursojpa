package br.curso.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.curso.jpa.bean.Tag;

public class TagDAO {
	private EntityManager em;
	private GenericDAO<Tag> dao;
	
	public TagDAO(EntityManager em) {
		this.em = em;
		dao = new GenericDAO<Tag>(em, Tag.class);
	}
	
	public Tag adicionarOuBuscarTag(String nome) {
		String jpql = "select t from Tag t " +
					  "where t.nome=:pNome";
		
		TypedQuery<Tag> query = em.createQuery(jpql, Tag.class);
		
		query.setParameter("pNome", nome);
		Tag tag = null;
		try {
			tag = query.getSingleResult();
		}
		catch (NoResultException exception) {
			tag = new Tag();
			tag.setNome(nome);
			em.persist(tag);
		}
		
		return tag;
	}
	
}
