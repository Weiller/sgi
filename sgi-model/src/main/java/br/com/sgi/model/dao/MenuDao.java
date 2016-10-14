package br.com.sgi.model.dao;

import java.util.List;

import br.com.sgi.model.entity.Menu;

public class MenuDao extends GenericDao<Short, Menu> {

	@SuppressWarnings("unchecked")
	public List<Menu> obterListaMenu(){
		return manager.createQuery("select m from Menu m LEFT JOIN FETCH m.menuFilhos m2").getResultList();
	}
	
}
