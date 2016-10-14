package br.com.sgi.model.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sgi.model.dao.UsuarioDAO;
import br.com.sgi.model.entity.Pessoa;
import br.com.sgi.model.entity.Usuario;

@Stateless
public class UsuarioRN {

	@Inject
	private UsuarioDAO dao;

	public void salvar(Usuario usuario) {
		dao.salvar(usuario);
	}

	public void recuperarPessoa(Usuario usuario, Pessoa pessoa) {
		usuario.setPessoa(pessoa);
	}
	
	public Usuario buscarPorLogin(String login){
		return dao.buscarPorLogin(login);
	}

	public void excluir(Usuario usuario) {
		dao.excluir(usuario);
	}
}
