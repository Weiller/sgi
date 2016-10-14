package br.com.sgi.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Menu implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="SEQ_MENU", sequenceName="SEQ_MENU", initialValue=1, allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MENU")
	private Short id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="menu_pai", referencedColumnName="id", updatable = false, insertable = false)
	private Menu parent;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="parent")
	private List<Menu> menuFilhos;
	
	@Column(name="caminho_pagina")
	private String caminhoPagina;
	
	@Column(name="nome_pagina", nullable=false)
	private String nomePagina;
	
	@Column(name="icone_pagina")
	private String iconePagina;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public List<Menu> getMenuFilhos() {
		return menuFilhos;
	}

	public void setMenuFilhos(List<Menu> menuFilhos) {
		this.menuFilhos = menuFilhos;
	}

	public String getCaminhoPagina() {
		return caminhoPagina;
	}

	public void setCaminhoPagina(String caminhoPagina) {
		this.caminhoPagina = caminhoPagina;
	}

	public String getNomePagina() {
		return nomePagina;
	}

	public void setNomePagina(String nomePagina) {
		this.nomePagina = nomePagina;
	}

	public String getIconePagina() {
		return iconePagina;
	}

	public void setIconePagina(String iconePagina) {
		this.iconePagina = iconePagina;
	}

}
