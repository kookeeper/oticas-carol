package br.com.msystem.oticas.carol.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1098645458265927812L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer enderecoSq;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String cidade;
	private String estado;

	/**
	 * @return the enderecoSq
	 */
	public Integer getEnderecoSq() {
		return enderecoSq;
	}

	/**
	 * @param enderecoSq the enderecoSq to set
	 */
	public void setEnderecoSq(Integer enderecoSq) {
		this.enderecoSq = enderecoSq;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
