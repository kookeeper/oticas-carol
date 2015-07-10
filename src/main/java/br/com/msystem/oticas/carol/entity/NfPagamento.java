package br.com.msystem.oticas.carol.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "nfPagamento")
public class NfPagamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2888507773207982368L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer nfPagamentoSq;
	private Integer numero;
	private float valor;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPagamento;
	@OneToMany
	private List<OrdemServico> listaOrdemServico;

	/**
	 * @return the nfPagamentoSq
	 */
	public Integer getNfPagamentoSq() {
		return nfPagamentoSq;
	}

	/**
	 * @param nfPagamentoSq the nfPagamentoSq to set
	 */
	public void setNfPagamentoSq(Integer nfPagamentoSq) {
		this.nfPagamentoSq = nfPagamentoSq;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

	/**
	 * @return the listaOrdemServico
	 */
	public List<OrdemServico> getListaOrdemServico() {
		if (listaOrdemServico == null) {
			setListaOrdemServico(new ArrayList<OrdemServico>());
		}
		return listaOrdemServico;
	}

	/**
	 * @param listaOrdemServico
	 *            the listaOrdemServico to set
	 */
	public void setListaOrdemServico(List<OrdemServico> listaOrdemServico) {
		this.listaOrdemServico = listaOrdemServico;
	}

	/**
	 * @return the dataPagamento
	 */
	public Date getDataPagamento() {
		return dataPagamento;
	}

	/**
	 * @param dataPagamento
	 *            the dataPagamento to set
	 */
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
