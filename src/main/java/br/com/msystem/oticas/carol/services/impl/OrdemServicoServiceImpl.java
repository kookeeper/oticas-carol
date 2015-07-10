package br.com.msystem.oticas.carol.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.msystem.oticas.carol.entity.OrdemServico;
import br.com.msystem.oticas.carol.services.OrdemServicoService;

@Service(value="osServiceImpl")
@Transactional
public class OrdemServicoServiceImpl implements OrdemServicoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4719567794244639645L;

	@PersistenceContext
	private EntityManager em;

	public OrdemServico salvar(OrdemServico os) {
		if (os.getOrdemServicoSq() == null) {
			em.persist(os);
		} else {
			os = em.merge(os);
		}
		return os;
	}

	public List<OrdemServico> listar() {
		return em.createNamedQuery("ordemServico.findAll", OrdemServico.class).getResultList();
	}

	public OrdemServico buscarPorId(Integer id) {
		return em.find(OrdemServico.class, id);
	}

	public List<OrdemServico> pesquisar(String filtro) {
		throw new UnsupportedOperationException("Filtrar O.S.");
	}

}
