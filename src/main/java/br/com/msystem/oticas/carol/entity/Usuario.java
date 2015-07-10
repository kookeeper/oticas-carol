package br.com.msystem.oticas.carol.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.msystem.oticas.carol.enums.Perfil;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8676461780574596845L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer usuarioSq;
	private String nomeUsuario;
	private Perfil perfilUsuario;
	private String login;
	private String senha;
	@Transient
	private String confirmacaoSenha;

	/**
	 * @return the usuarioSq
	 */
	public Integer getUsuarioSq() {
		return usuarioSq;
	}

	/**
	 * @param usuarioSq the usuarioSq to set
	 */
	public void setUsuarioSq(Integer usuarioSq) {
		this.usuarioSq = usuarioSq;
	}

	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/**
	 * @param nomeUsuario
	 *            the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * @return the perfilUsuario
	 */
	public Perfil getPerfilUsuario() {
		return perfilUsuario;
	}

	/**
	 * @param perfilUsuario
	 *            the perfilUsuario to set
	 */
	public void setPerfilUsuario(Perfil perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the confirmacaoSenha
	 */
	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	/**
	 * @param confirmacaoSenha
	 *            the confirmacaoSenha to set
	 */
	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

}
