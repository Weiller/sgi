package br.com.sgi.model.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sgi.model.dao.MenuDao;
import br.com.sgi.model.entity.Menu;

@Stateless
public class MenuRN{
	
	@Inject
	private MenuDao menuDao;
	
	public List<Menu> obterListaMenu(){
		return menuDao.obterListaMenu();
	}
}
