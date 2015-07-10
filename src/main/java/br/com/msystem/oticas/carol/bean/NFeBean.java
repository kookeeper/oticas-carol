package br.com.msystem.oticas.carol.bean;

import java.io.Serializable;
import java.util.Date;

public class NFeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6446082217155517501L;
	private Integer numeroNFe;
	private Float valorNFe;
	private Date dataEmissaoNFe;
	private Integer fornecedorNFe;

	/**
	 * @return the numeroNFe
	 */
	public Integer getNumeroNFe() {
		return numeroNFe;
	}

	/**
	 * @param numeroNFe
	 *            the numeroNFe to set
	 */
	public void setNumeroNFe(Integer numeroNFe) {
		this.numeroNFe = numeroNFe;
	}

	/**
	 * @return the valorNFe
	 */
	public Float getValorNFe() {
		return valorNFe;
	}

	/**
	 * @param valorNFe
	 *            the valorNFe to set
	 */
	public void setValorNFe(Float valorNFe) {
		this.valorNFe = valorNFe;
	}

	/**
	 * @return the dataEmissaoNFe
	 */
	public Date getDataEmissaoNFe() {
		return dataEmissaoNFe;
	}

	/**
	 * @param dataEmissaoNFe
	 *            the dataEmissaoNFe to set
	 */
	public void setDataEmissaoNFe(Date dataEmissaoNFe) {
		this.dataEmissaoNFe = dataEmissaoNFe;
	}

	/**
	 * @return the fornecedorNFe
	 */
	public Integer getFornecedorNFe() {
		return fornecedorNFe;
	}

	/**
	 * @param fornecedorNFe
	 *            the fornecedorNFe to set
	 */
	public void setFornecedorNFe(Integer fornecedorNFe) {
		this.fornecedorNFe = fornecedorNFe;
	}

}
