package br.com.msystem.oticas.carol.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.msystem.oticas.carol.bean.ResumoVenda;
import br.com.msystem.oticas.carol.entity.Venda;
import br.com.msystem.oticas.carol.services.VendaService;

@Service
@Transactional
public class VendaServiceImpl implements VendaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6406954942893377604L;
	@PersistenceContext
	private EntityManager em;

	public Venda salvar(Venda venda) {
		if (venda.getVendaSq() == null) {
			em.persist(venda);
		} else {
			venda = em.merge(venda);
		}
		return venda;
	}

	public List<Venda> listar() {
		return em.createNamedQuery("venda.findAll", Venda.class)
				.getResultList();
	}

	public Venda buscarPorId(Integer id) {
		return em.find(Venda.class, id);
	}

	public List<Venda> pesquisar(String filtro) {
		throw new UnsupportedOperationException("Pesquisar Venda");
	}

	@Override
	public List<ResumoVenda> listarResumoVenda(Date dataInicial, Date dataFinal) {
		Query query = em.createNamedQuery("venda.listaResumoVenda");

		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);

		@SuppressWarnings("unchecked")
		List<Object[]> lista = query.getResultList();

		List<ResumoVenda> resultado = new ArrayList<ResumoVenda>();

		for (Object[] bean : lista) {
			resultado.add(new ResumoVenda((Integer) bean[0], (Date) bean[1],
					(Double) bean[2], (Double) bean[3]));
		}

		return resultado;

	}

}
