package br.com.sgi.controller.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import br.com.sgi.model.business.MenuRN;
import br.com.sgi.model.entity.Menu;

public class MenuController extends SgiController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MenuRN menuRN;
	
	private List<Menu> menuList;
	
	private MenuModel model;

	@PostConstruct
	public void init(){
		if(menuList == null){
			menuList = menuRN.obterListaMenu();
			criarMenu();
		}
	}

	private void criarMenu() {
		model = new DefaultMenuModel();
		DefaultSubMenu subMenu = null;
		DefaultMenuItem menuItem = null;
		for(Menu menu : menuList){
			
			if(menu.getParent() == null){
				subMenu = new DefaultSubMenu();
				subMenu.setLabel(menu.getNomePagina());
				
				for(Menu menuFilho : menu.getMenuFilhos()){
					if(menuFilho.getMenuFilhos().isEmpty()){
						menuItem = new DefaultMenuItem();
						menuItem.setValue(menuFilho.getNomePagina());
						menuItem.setUrl(menuFilho.getCaminhoPagina());
						subMenu.addElement(menuItem);
					} else{
						DefaultSubMenu sm = new DefaultSubMenu();
						sm = criarSubMenu(menuFilho);
						subMenu.addElement(sm);
					}
				}
				model.addElement(subMenu);
			}
		}
	}

	private DefaultSubMenu criarSubMenu(Menu menuFilho) {
		DefaultSubMenu subMenu = new DefaultSubMenu();
		
		subMenu.setLabel(menuFilho.getNomePagina());
		
		for(Menu menuNeto : menuFilho.getMenuFilhos()){
			if(menuNeto.getMenuFilhos().isEmpty()){
				DefaultMenuItem menuItem = null;
				menuItem = new DefaultMenuItem();
				menuItem.setValue(menuNeto.getNomePagina());
				menuItem.setUrl(menuNeto.getCaminhoPagina());
				subMenu.addElement(menuItem);
			} else{
				subMenu.addElement(criarSubMenu(menuNeto));
			}
		}
		return subMenu;
	}

	public List<Menu> getMenus() {
		return menuList;
	}

	public void setMenus(List<Menu> menus) {
		this.menuList = menus;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

}
