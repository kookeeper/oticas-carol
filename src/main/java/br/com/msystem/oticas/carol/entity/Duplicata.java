package br.com.msystem.oticas.carol.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "duplicata")
public class Duplicata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5806798863325134456L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer duplicataSq;
	@ManyToOne
	private Nfe nfe;
	private String numero;
	private Float valor;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVencimento;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPagamento;

	/**
	 * @return the duplicataSq
	 */
	public Integer getDuplicataSq() {
		return duplicataSq;
	}

	/**
	 * @param duplicataSq
	 *            the duplicataSq to set
	 */
	public void setDuplicataSq(Integer duplicataSq) {
		this.duplicataSq = duplicataSq;
	}

	/**
	 * @return the nfe
	 */
	public Nfe getNfe() {
		return nfe;
	}

	/**
	 * @param nfe
	 *            the nfe to set
	 */
	public void setNfe(Nfe nfe) {
		this.nfe = nfe;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the valor
	 */
	public Float getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(Float valor) {
		this.valor = valor;
	}

	/**
	 * @return the dataVencimento
	 */
	public Date getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * @param dataVencimento
	 *            the dataVencimento to set
	 */
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
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
