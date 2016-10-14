package br.com.sgi.model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sgi.model.interfaces.Dao;

@Stateless
public class GenericDao<PK, T> implements Dao<PK, T> {

	@PersistenceContext(unitName = "sgi")
	protected EntityManager manager;
	
	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}

	@Override
	public void persistir(T entidade) {
		manager.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		manager.merge(entidade);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T obterPorId(PK pk) {
		return (T) manager.find(getTypeClass(), pk);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> listarTodos() {
		return manager.createQuery(("FROM" + getTypeClass().getName()))
				.getResultList();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
