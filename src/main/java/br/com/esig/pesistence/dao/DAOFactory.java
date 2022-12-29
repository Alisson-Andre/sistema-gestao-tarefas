package br.com.esig.pesistence.dao;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.esig.pesistence.daointerface.DAO;
import br.com.esig.pesistence.model.AbstractEntity;

public class DAOFactory {

	@Inject
	private EntityManager em;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Produces
	@Dependent
	public <T extends AbstractEntity> DAO<T> createDAO(InjectionPoint point) {
		ParameterizedType type = (ParameterizedType) point.getType();
		Class classe = (Class) type.getActualTypeArguments()[0];
		return new DAOImpl<T>(classe, em);
	}
}
