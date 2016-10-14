package br.com.sgi.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.sgi.model.entity.Usuario;

public class UsuarioDAO {

	@PersistenceContext(unitName = "sgi")
	private EntityManager manager;

	public void salvar(Usuario usuario) {
		manager.merge(usuario);
	}

	public Usuario buscarPorLogin(String login) {
		Usuario usuario = null;
		try {
			usuario = manager.createQuery("select u from Usuario u where lower(login) = :login",
							Usuario.class).setParameter("login", login.toLowerCase()).getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("Não retornou dados");
		}
		return usuario;
	}

	public void excluir(Usuario usuario) {
		manager.remove(usuario);
	}

}
