package br.com.msystem.oticas.carol.services;

import java.util.List;

import br.com.msystem.oticas.carol.entity.Duplicata;

public interface DuplicataService extends GenericService<Duplicata> {

	public List<Duplicata> listarEmAberto();

	public List<Duplicata> listarPagas();

}
