package br.com.msystem.oticas.carol.services;

import br.com.msystem.oticas.carol.entity.Usuario;

public interface UsuarioService extends GenericService<Usuario> {
	
	public Usuario buscarPorLogin(String login);

}
