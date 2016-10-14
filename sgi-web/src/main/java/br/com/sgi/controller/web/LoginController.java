package br.com.sgi.controller.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.sgi.util.jsf.JSFUtil;

@Named
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	
	private String senha;

	public String logar(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		
		try {
			login = "weiller";
			senha = "weiller";
			request.login(login, senha);
		} catch (ServletException e) {
			JSFUtil.addMessageError("LOGIN_SENHA_INCORRETA");
			return null;
		}
		
		return "inicio?faces-redirect=true";
	}

	public void verificarSeUsuarioExiste() {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
