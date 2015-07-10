package br.com.msystem.oticas.carol.services;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T> extends Serializable {

	public List<T> listar();

	public T buscarPorId(Integer id);

	public T salvar(T entity);

	public List<T> pesquisar(String filtro);

}
