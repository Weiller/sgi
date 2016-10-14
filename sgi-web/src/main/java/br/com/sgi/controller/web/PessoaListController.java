package br.com.sgi.controller.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.sgi.model.business.PessoaRN;
import br.com.sgi.model.entity.Pessoa;

public class PessoaListController extends SgiController{

	private static final long serialVersionUID = -8939493687435335844L;
	
	@Inject
	private PessoaListController controller;
	
	@Inject
	private PessoaRN pessoaRN;
	
	private List<Pessoa> pessoasList;
	
	@PostConstruct
	public void init(){
		iniciarConversacao();
	}
	public void inicio(){
		pessoasList = pessoaRN.listarTodos();
	}
		
	public String editar(){
		return "cadastrarMembro";
	}
	
	public String redirecionar(){
		return "cadastrarMembro";
	}
	
	public List<Pessoa> getPessoasList() {
		return pessoasList;
	}

	public void setPessoasList(List<Pessoa> pessoasList) {
		this.pessoasList = pessoasList;
	}


	public PessoaListController getController() {
		return controller;
	}

	public void setController(PessoaListController controller) {
		this.controller = controller;
	}
}
