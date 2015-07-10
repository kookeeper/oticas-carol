package br.com.msystem.oticas.carol.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.msystem.oticas.carol.entity.Pessoa;
import br.com.msystem.oticas.carol.services.PessoaService;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2305763027921376118L;
	@PersistenceContext
	private EntityManager em;

	public Pessoa buscarPorId(Integer id) {
		return em.find(Pessoa.class, id);
	}

	public List<Pessoa> listarFornecedor() {
		return em.createNamedQuery("fornecedor.findAll", Pessoa.class)
				.getResultList();
	}

	public List<Pessoa> listarFornecedor(String filtro) {
		return em.createNamedQuery("fornecedor.procurar", Pessoa.class)
				.setParameter("filtro", "%" + filtro + "%").getResultList();
	}

	public List<Pessoa> listarLaboratorio() {
		return em.createNamedQuery("laboratorio.findAll", Pessoa.class)
				.getResultList();
	}

	public List<Pessoa> listarLaboratorio(String filtro) {
		return em.createNamedQuery("laboratorio.procurar", Pessoa.class)
				.setParameter("filtro", "%" + filtro + "%").getResultList();
	}

	public List<Pessoa> listarCliente() {
		return em.createNamedQuery("cliente.findAll", Pessoa.class)
				.getResultList();
	}

	public List<Pessoa> listarCliente(String filtro) {
		return em.createNamedQuery("cliente.procurar", Pessoa.class)
				.setParameter("filtro", "%" + filtro + "%").getResultList();
	}

	public List<Pessoa> pesquisar(String filtro) {
		TypedQuery<Pessoa> query = em.createNamedQuery("pessoa.procurar",
				Pessoa.class);
		query.setParameter("filtro", "%" + filtro + "%");
		return query.getResultList();
	}

	public Pessoa buscarPorCodigo(String codigo) {
		TypedQuery<Pessoa> query = em.createNamedQuery(
				"pessoa.buscarPorCodigo", Pessoa.class);
		query.setParameter("codigo", codigo);

		try {
			return query.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			return null;
		}
	}

	public Pessoa salvar(Pessoa pessoa) {
		if (pessoa.getPessoaSq() == null) {
			em.persist(pessoa);
		} else {
			pessoa = em.merge(pessoa);
		}
		return pessoa;
	}

	public List<Pessoa> listar() {
		throw new UnsupportedOperationException("Listar pessoas");
	}

}
