package br.com.sgi.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sgi.model.dao.MenuDao;
import br.com.sgi.model.entity.Menu;

public class MenuDaoTest {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("sgi-test");

		EntityManager manager = factory.createEntityManager();
		MenuDao dao = new MenuDao();
		dao.setManager(manager);

		List<Menu> menus = dao.obterListaMenu();

		for (Menu menu : menus) {
			System.out.println(menu.getCaminhoPagina());
			
//			for(Menu menu1 : menu.getMenuFilho()){
//				System.out.println(menu1.getCaminhoPagina());
//			}
		}

	}
}
