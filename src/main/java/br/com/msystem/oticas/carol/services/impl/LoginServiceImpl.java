package br.com.msystem.oticas.carol.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.msystem.oticas.carol.entity.Usuario;
import br.com.msystem.oticas.carol.enums.Perfil;

@Service("loginServiceImpl")
@Transactional
public class LoginServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {

			Usuario usuario = usuarioService.buscarPorLogin(username);

			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;

			return new User(usuario.getLogin(), usuario.getSenha(), enabled,
					accountNonExpired, credentialsNonExpired, accountNonLocked,
					getAuthorities(usuario.getPerfilUsuario()));

		} catch (NoResultException e) {
			throw new RuntimeException(
					"Não foi possível encontrar o usuario informado.");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Retrieves a collection of {@link GrantedAuthority} based on a numerical
	 * role
	 * 
	 * @param role
	 *            the numerical role
	 * @return a collection of {@link GrantedAuthority
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Perfil perfil) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(perfil));
		return authList;
	}

	/**
	 * Converts a numerical role to an equivalent list of roles
	 * 
	 * @param role
	 *            the numerical role
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(Perfil perfil) {
		List<String> roles = new ArrayList<String>();

		if (perfil.equals(Perfil.GERENTE)) {
			roles.add("ROLE_USER");
		}

		if (perfil.equals(Perfil.MASTER)) {
			roles.add("ROLE_USER");
		}

		return roles;
	}

	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
	 * 
	 * @param roles
	 *            {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
