package br.com.esig.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.esig.persistence.daointerface.DAO;
import br.com.esig.persistence.model.AbstractEntity;

public class DAOImpl<T extends AbstractEntity> implements DAO<T> {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	private final Class<T> classe;

	public DAOImpl(Class<T> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;
	}

	@Override
	public T save(T entity) {

		if (entity.getId() == null) {
			em.persist(entity);
		} else {
			em.merge(entity);
		}
		em.flush();

		return entity;
	}

	@Override
	public T update(T entity) {
		em.merge(entity);
		em.flush();
		return entity;
	}

	@Override
	public List<T> listAll() {
		StringBuilder sql = new StringBuilder();
		sql.append("Select x from ").append(this.classe.getSimpleName()).append(" x");
		TypedQuery<T> query = em.createQuery(sql.toString(), this.classe);
		return query.getResultList();
	}

	@Override
	public void remove(T entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		em.flush();
	}

	@Override
	public T findById(Long id) {
		return em.find(this.classe, id);
	}

}
