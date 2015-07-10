package br.com.msystem.oticas.carol.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.msystem.oticas.carol.entity.Duplicata;
import br.com.msystem.oticas.carol.services.DuplicataService;

@Service
@Transactional
public class DuplicataServiceImpl implements DuplicataService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4256906481086524936L;
	
	@PersistenceContext
	private EntityManager em;

	public List<Duplicata> listar() {
		TypedQuery<Duplicata> query = em.createNamedQuery("duplicata.findAll", Duplicata.class);
		return query.getResultList();
	}

	public Duplicata buscarPorId(Integer id) {
		return em.find(Duplicata.class, id);
	}

	public List<Duplicata> pesquisar(String filtro) {
		TypedQuery<Duplicata> query = em.createNamedQuery("duplicata.procurar", Duplicata.class);
		query.setParameter("filtro", "%" + filtro + "%");
		return query.getResultList();
	}
	
	public List<Duplicata> listarEmAberto() {
		TypedQuery<Duplicata> query = em.createNamedQuery("duplicata.emAberto", Duplicata.class);
		return query.getResultList();
	}
	
	public List<Duplicata> listarPagas() {
		TypedQuery<Duplicata> query = em.createNamedQuery("duplicata.pagas", Duplicata.class);
		return query.getResultList();
	}
	
	public Duplicata salvar(Duplicata duplicata) {
		if (duplicata.getDuplicataSq() == null) {
			em.persist(duplicata);
		} else {
			duplicata = em.merge(duplicata);
		}
		return duplicata;
	}

}
