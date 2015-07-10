package br.com.msystem.oticas.carol.services;

import java.util.List;

import br.com.msystem.oticas.carol.entity.Pessoa;

public interface PessoaService extends GenericService<Pessoa> {
	
	public List<Pessoa> listarFornecedor();
	
	public List<Pessoa> listarFornecedor(String filtro);
	
	public List<Pessoa> listarLaboratorio();

	public List<Pessoa> listarLaboratorio(String filtro);

	public List<Pessoa> listarCliente();

	public List<Pessoa> listarCliente(String filtro);

	public Pessoa buscarPorCodigo(String codigo);
	
}
