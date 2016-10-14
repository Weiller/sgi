package br.com.sgi.model.business;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.sgi.model.dao.PessoaDao;
import br.com.sgi.model.entity.Pessoa;
import br.com.sgi.util.jsf.JSFUtil;
	
public class PessoaRN implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private PessoaDao dao;

	public void salvar(Pessoa pessoa) {
		try {
			dao.salvar(pessoa);
			if (pessoa.getId() == null) {
				JSFUtil.addMessageInfo("CADASTRO_SUCESSO");
			} else {
				JSFUtil.addMessageInfo("EDITAR_SUCESSO");
			}
		} catch (Exception e) {
			JSFUtil.addMessageError("CADASTRO_ERRO");
		}
	}

	public List<Pessoa> listarTodos() {
		return dao.listarTodos();
	}

	public Pessoa buscarPorID(Integer id) {
		return dao.buscarPorID(id);
	}
	
	public List<Pessoa> buscarPessoas(Pessoa pessoa){
		
		return dao.buscarPessoas(pessoa);
	}

	public void excluir(Pessoa pessoa) {
		if (pessoa.getUsuario() != null) {
			JSFUtil.addMessageError("EXCLUIR_ERRO_PESSOA_CHAVE_ESTRANGEIRA");
		} else {
			dao.excluir(pessoa);
			JSFUtil.addMessageInfo("EXCLUIR_SUCESSO");
		}
	}
}
