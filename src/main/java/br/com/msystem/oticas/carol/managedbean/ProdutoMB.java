package br.com.msystem.oticas.carol.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;

import br.com.msystem.oticas.carol.entity.Produto;
import br.com.msystem.oticas.carol.services.ProdutoService;

@ManagedBean
@ViewScoped
@Transactional
public class ProdutoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -571688318255045747L;
	
	@ManagedProperty(value="#{produtoServiceImpl}")
	private ProdutoService produtoService;
	private List<Produto> listaProduto;
	private Produto produtoSelecionado;

	public List<Produto> completarProduto(String query) {

		List<Produto> produtosFiltrados = produtoService.pesquisar(query);

		return produtosFiltrados;
	}

	public void incluirProduto(ActionEvent event) {
		setProdutoSelecionado(new Produto());
	}
	
	public String gravarProduto() {
		produtoService.salvar(getProdutoSelecionado());
		setListaProduto(null);

		return null;
	}
	
	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	public List<Produto> getListaProduto() {
		if (listaProduto == null) {
			setListaProduto(produtoService.listar());
		}
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
}
