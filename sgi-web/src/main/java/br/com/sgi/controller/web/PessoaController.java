package br.com.sgi.controller.web;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

import br.com.sgi.model.business.PessoaRN;
import br.com.sgi.model.entity.Pessoa;

public class PessoaController extends SgiController{

	private static final long serialVersionUID = 5930991296376511746L;

	private Pessoa pessoa;
	
	@Inject
	private PessoaRN pessoaRN;
	
	private List<Pessoa> pessoasList;
	
	@Inject
	private Conversation conversation;
	
	@PostConstruct
	public void init(){
		iniciarConversacao();
		if(pessoa == null){
			pessoa = new Pessoa();
		}
	}

	public String salvarPessoa(){
		pessoaRN.salvar(this.pessoa);
		limparPessoa();
		return "membroList";
	}

	public String redirecionar(){
		return "membroList";
	}
	
	public void limparPessoa(){
		pessoa = new Pessoa();
	}
	
	public Date getDateHoje() {
		return new Date();
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoasList() {
		return pessoasList;
	}

	public void setPessoasList(List<Pessoa> pessoasList) {
		this.pessoasList = pessoasList;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
}
