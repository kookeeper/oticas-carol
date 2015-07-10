package br.com.msystem.oticas.carol.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.msystem.oticas.carol.entity.Produto;
import br.com.msystem.oticas.carol.services.ProdutoService;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6643093119584517793L;
	@PersistenceContext
	private EntityManager em;

	public List<Produto> listar() {
		TypedQuery<Produto> query = em.createNamedQuery("produto.findAll",
				Produto.class);
		return query.getResultList();
	}

	public Produto buscarPorId(Integer id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> pesquisar(String filtro) {
		TypedQuery<Produto> query = em.createNamedQuery("produto.procurar",
				Produto.class);
		query.setParameter("filtro", "%" + filtro + "%");
		return query.getResultList();
	}

	public Produto salvar(Produto produto) {
		if (produto.getProdutoSq() == null) {
			em.persist(produto);
		} else {
			produto = em.merge(produto);
		}
		return produto;
	}

	public Produto buscarPorCodigo(String codigo) {
		TypedQuery<Produto> query = em.createNamedQuery(
				"produto.procurarPorCodigo", Produto.class);
		query.setParameter("codigoProduto", codigo);
		try {
			return query.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			return null;
		}
	}

}
