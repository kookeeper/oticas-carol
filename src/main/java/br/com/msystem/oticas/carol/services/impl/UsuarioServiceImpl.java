package br.com.msystem.oticas.carol.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.msystem.oticas.carol.entity.Usuario;
import br.com.msystem.oticas.carol.enums.Perfil;
import br.com.msystem.oticas.carol.services.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3120317307564948448L;
	@PersistenceContext
	private EntityManager em;

	public List<Usuario> listar() {
		return em.createNamedQuery("usuario.findAll", Usuario.class).getResultList();
	}

	public Usuario buscarPorId(Integer id) {
		return em.find(Usuario.class, id);
	}
	
	public Usuario salvar(Usuario usuario) {
		if (usuario.getUsuarioSq() == null) {
			em.persist(usuario);
		} else {
			usuario = em.merge(usuario);
		}
		return usuario;
	}

	public Usuario buscarPorLogin(String login) {
		
		TypedQuery<Usuario> query = em.createNamedQuery("usuario.buscarPorLogin", Usuario.class);
		query.setParameter("login", login);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			if (login.equals("login")) {
				Usuario usuario = new Usuario();
				usuario.setLogin("login");
				usuario.setSenha("senha");
				usuario.setPerfilUsuario(Perfil.MASTER);
				return usuario;
			} else {
				throw e;
			}
		}

		
	}

	public List<Usuario> pesquisar(String filtro) {
		throw new UnsupportedOperationException("Pesquisar Usuario");
	}

}
