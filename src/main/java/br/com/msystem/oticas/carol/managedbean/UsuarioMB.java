package br.com.msystem.oticas.carol.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;

import br.com.msystem.oticas.carol.entity.Usuario;
import br.com.msystem.oticas.carol.enums.Perfil;
import br.com.msystem.oticas.carol.services.UsuarioService;

@ManagedBean
@ViewScoped
@Transactional
public class UsuarioMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1257972575783239688L;
	
	@ManagedProperty(value="#{usuarioServiceImpl}")
	private UsuarioService usuarioService;
	private List<Usuario> listaUsuario;
	private Usuario usuarioSelecionado;

	public Perfil[] getListaPerfilUsuario() {
		return Perfil.values();
	}

	public void incluirUsuario(ActionEvent event) {
		setUsuarioSelecionado(new Usuario());
	}

	public String gravarUsuario() {
		usuarioService.salvar(getUsuarioSelecionado());
		setListaUsuario(null);

		return null;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			setListaUsuario(usuarioService.listar());
		}
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
}
