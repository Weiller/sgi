package br.com.sgi.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sgi.model.dao.PessoaDao;
import br.com.sgi.model.entity.Pessoa;

public class PessoaDaoTest {
	
	public static void main(String[] args) {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("sgi-test");
		
		EntityManager manager = factory.createEntityManager();
		PessoaDao dao = new PessoaDao();
		dao.setManager(manager);
		
		Pessoa pessoa = dao.obterPorId(1);
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getNome() + "2");		
		
		List<Pessoa> pessoas = dao.listarTodos();
		
		for(Pessoa pessoa1 : pessoas){
			System.out.println(pessoa1.getNome());
		}
		
	}

}
