package br.com.sgi.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;

import br.com.sgi.model.entity.Pessoa;
@Stateless
public class PessoaDao extends GenericDao<Integer, Pessoa> {

	public void salvar(Pessoa pessoa) {
		manager.merge(pessoa);
	}

	public void flush() {
		manager.flush();
	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public List<Pessoa> listarTodos() {
		return manager.createQuery(
				"select p from Pessoa p LEFT JOIN FETCH p.usuario",
				Pessoa.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarPessoas(Pessoa pessoa) {
		
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("SELECT p from Pessoa p LEFT JOIN FETCH p.usuario WHERE lower(nome) like lower(:nome)");
		
		if(pessoa.getUsuario().getLogin() != null && !pessoa.getUsuario().getLogin().equals("")){
			jpql.append(" and lower(p.usuario.login) like lower(:login) ");
		}
		
		Query query = manager
				.createQuery(jpql.toString());
		

		if(pessoa.getUsuario().getLogin() != null && !pessoa.getUsuario().getLogin().equals("")){
			query.setParameter("login", "%" +pessoa.getUsuario().getLogin()+ "%");
		}
		
		query.setParameter("nome", "%" + pessoa.getNome()+ "%");
		
		
		return query.getResultList();
	}

	public Pessoa buscarPorID(Integer id) {
		return manager.find(Pessoa.class, id);
	}

	public void excluir(Pessoa pessoa) throws ConstraintViolationException {
		manager.remove(manager.merge(pessoa));
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
