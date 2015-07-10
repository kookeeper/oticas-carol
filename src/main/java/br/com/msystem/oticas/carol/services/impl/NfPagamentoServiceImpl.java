package br.com.msystem.oticas.carol.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.msystem.oticas.carol.entity.NfPagamento;
import br.com.msystem.oticas.carol.services.NfPagamentoService;

@Service(value="nfPagamentoServiceImpl")
@Transactional
public class NfPagamentoServiceImpl implements NfPagamentoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2314797009075451554L;
	
	@PersistenceContext
	private EntityManager em;

	public NfPagamento salvar(NfPagamento os) {
		if (os.getNfPagamentoSq() == null) {
			em.persist(os);
		} else {
			os = em.merge(os);
		}
		return os;
	}

	public List<NfPagamento> listar() {
		return em.createNamedQuery("nfPagamento.findAll", NfPagamento.class).getResultList();
	}

	public NfPagamento buscarPorId(Integer id) {
		return em.find(NfPagamento.class, id);
	}

	public List<NfPagamento> pesquisar(String filtro) {
		throw new UnsupportedOperationException("Filtrar Nota Fiscal");
	}

}
