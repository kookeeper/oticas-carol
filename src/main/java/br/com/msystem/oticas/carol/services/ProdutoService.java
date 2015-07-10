package br.com.msystem.oticas.carol.services;

import br.com.msystem.oticas.carol.entity.Produto;

public interface ProdutoService extends GenericService<Produto> {
	
	public Produto buscarPorCodigo(String codigo);

}
