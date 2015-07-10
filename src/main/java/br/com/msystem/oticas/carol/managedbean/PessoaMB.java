package br.com.msystem.oticas.carol.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transactional;

import br.com.msystem.oticas.carol.entity.Pessoa;
import br.com.msystem.oticas.carol.enums.TipoPessoa;
import br.com.msystem.oticas.carol.services.PessoaService;

@ManagedBean
@ViewScoped
@Transactional
public class PessoaMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2165338862315276320L;
	
	@ManagedProperty(value="#{pessoaServiceImpl}")
	private PessoaService pessoaService;
	private Pessoa pessoaSelecionada;

	public TipoPessoa[] getListaTipoPessoa() {
		return TipoPessoa.values();
	}

	public List<Pessoa> completarPessoa(String query) {
		
		List<Pessoa> pessoasFiltradas = pessoaService.pesquisar(query);
		
        return pessoasFiltradas;
    }
	
	public String gravarPessoa() {
		pessoaService.salvar(pessoaSelecionada);
		
		return null;
	}
	
	public void incluirPessoa() {
		pessoaSelecionada = new Pessoa();
	}

	public PessoaService getPessoaService() {
		return pessoaService;
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

}
