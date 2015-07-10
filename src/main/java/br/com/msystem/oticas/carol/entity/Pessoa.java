package br.com.msystem.oticas.carol.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.msystem.oticas.carol.enums.TipoCadastroPessoa;
import br.com.msystem.oticas.carol.enums.TipoPessoa;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2106992114954708937L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pessoaSq;
	private String codigoPessoa;
	private String nomePessoa;
	private String telefoneFixoPessoa;
	private String telefoneCelularPessoa;
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco enderecoPessoa;
	private TipoPessoa tipoPessoa;
	private TipoCadastroPessoa tipoCadastroPessoa;

	public Pessoa() {
		this.enderecoPessoa = new Endereco();
	}
	/**
	 * @return the pessoaSq
	 */
	public Integer getPessoaSq() {
		return pessoaSq;
	}

	/**
	 * @param pessoaSq
	 *            the pessoaSq to set
	 */
	public void setPessoaSq(Integer numeroPessoa) {
		this.pessoaSq = numeroPessoa;
	}

	/**
	 * @return the codigoPessoa
	 */
	public String getCodigoPessoa() {
		return codigoPessoa;
	}

	/**
	 * @param codigoPessoa
	 *            the codigoPessoa to set
	 */
	public void setCodigoPessoa(String codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	/**
	 * @return the nomePessoa
	 */
	public String getNomePessoa() {
		return nomePessoa;
	}

	/**
	 * @param nomePessoa
	 *            the nomePessoa to set
	 */
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	/**
	 * @return the telefoneFixoPessoa
	 */
	public String getTelefoneFixoPessoa() {
		return telefoneFixoPessoa;
	}

	/**
	 * @param telefoneFixoPessoa
	 *            the telefoneFixoPessoa to set
	 */
	public void setTelefoneFixoPessoa(String telefoneFixoPessoa) {
		this.telefoneFixoPessoa = telefoneFixoPessoa;
	}

	/**
	 * @return the telefoneCelularPessoa
	 */
	public String getTelefoneCelularPessoa() {
		return telefoneCelularPessoa;
	}

	/**
	 * @param telefoneCelularPessoa
	 *            the telefoneCelularPessoa to set
	 */
	public void setTelefoneCelularPessoa(String telefoneCelularPessoa) {
		this.telefoneCelularPessoa = telefoneCelularPessoa;
	}

	public Endereco getEnderecoPessoa() {
		return enderecoPessoa;
	}

	public void setEnderecoPessoa(Endereco enderecoPessoa) {
		this.enderecoPessoa = enderecoPessoa;
	}

	/**
	 * @return the tipoPessoa
	 */
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	/**
	 * @param tipoPessoa
	 *            the tipoPessoa to set
	 */
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	/**
	 * @return the tipoCadastroPessoa
	 */
	public TipoCadastroPessoa getTipoCadastroPessoa() {
		return tipoCadastroPessoa;
	}

	/**
	 * @param tipoCadastroPessoa the tipoCadastroPessoa to set
	 */
	public void setTipoCadastroPessoa(TipoCadastroPessoa tipoCadastroPessoa) {
		this.tipoCadastroPessoa = tipoCadastroPessoa;
	}

}
