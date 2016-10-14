package br.com.sgi.controller.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgi.model.business.PessoaRN;
import br.com.sgi.model.business.UsuarioRN;
import br.com.sgi.model.entity.Pessoa;
import br.com.sgi.model.entity.Status;
import br.com.sgi.model.entity.Usuario;

@Named
@RequestScoped
public class UsuarioController {

	@Inject
	private Usuario usuario;

	@Inject
	private Pessoa pessoa;

	@Inject
	private PessoaRN pessoaRN;

	private List<Pessoa> pessoasList;
	@Inject
	private PessoaController pessoaController;

	@Inject
	private UsuarioRN usuarioRN;

	private String renderizaPagina;

	@PostConstruct
	public void iniciar() {
		carregarListaPessoas();
	}

	public void salvarUsuario() {
		usuario.setPessoa(pessoa);
		usuarioRN.salvar(usuario);
		limparForm();
		carregarListaPessoas();
	}

	public void selecionar(Pessoa pessoa) {
		this.pessoa = pessoa;
		if (pessoa.getUsuario() != null) {
			this.usuario = pessoa.getUsuario();
		}
	}
	
	public String editar(Pessoa pessoa){
		return "cadastrarMembro";
	}

	public void carregarListaPessoas() {
		pessoasList = pessoaRN.listarTodos();
	}

	public void limparForm() {
		pessoa = new Pessoa();
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getRenderizaPagina() {
		return renderizaPagina;
	}

	public void setRenderizaPagina(String renderizaPagina) {
		this.renderizaPagina = renderizaPagina;
	}

	// Retorna valores da Enum Status
	public Status[] getStatus() {
		return Status.values();
	}

	public PessoaController getPessoaController() {
		return pessoaController;
	}

	public void setPessoaController(PessoaController pessoaController) {
		this.pessoaController = pessoaController;
	}

}
