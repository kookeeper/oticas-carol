package br.com.msystem.oticas.carol.services;

import java.util.Date;
import java.util.List;

import br.com.msystem.oticas.carol.bean.ResumoVenda;
import br.com.msystem.oticas.carol.entity.Venda;

public interface VendaService extends GenericService<Venda> {

	public List<ResumoVenda> listarResumoVenda(Date dataInicial, Date dataFinal);
	
}
