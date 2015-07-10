package br.com.msystem.oticas.carol.bean;

import java.io.Serializable;
import java.util.Date;

public class ResumoVenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7378479687094702136L;

	private Integer numeroVenda;
	private Date dataVenda;
	private Double valorVenda;
	private Double valorCusto;

	public ResumoVenda(Integer numeroVenda, Date dataVenda, Double valorVenda,
			Double valorCusto) {

		this.numeroVenda = numeroVenda;
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
		this.valorCusto = valorCusto;

	}

	/**
	 * @return the numeroVenda
	 */
	public Integer getNumeroVenda() {
		return numeroVenda;
	}

	/**
	 * @param numeroVenda
	 *            the numeroVenda to set
	 */
	public void setNumeroVenda(Integer numeroVenda) {
		this.numeroVenda = numeroVenda;
	}

	/**
	 * @return the dataVenda
	 */
	public Date getDataVenda() {
		return dataVenda;
	}

	/**
	 * @param dataVenda
	 *            the dataVenda to set
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	/**
	 * @return the valorVenda
	 */
	public Double getValorVenda() {
		return valorVenda;
	}

	/**
	 * @param valorVenda
	 *            the valorVenda to set
	 */
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	/**
	 * @return the valorCusto
	 */
	public Double getValorCusto() {
		return valorCusto;
	}

	/**
	 * @param valorCusto
	 *            the valorCusto to set
	 */
	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}

}
