package br.com.msystem.oticas.carol.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4602691502463382699L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer produtoSq;
	private String codigoProduto;
	private String descricaoProduto;
	private Float custoMedioProduto;
	private Integer quantidadeProduto;


	/**
	 * @return the produtoSq
	 */
	public Integer getProdutoSq() {
		return produtoSq;
	}

	/**
	 * @param produtoSq the produtoSq to set
	 */
	public void setProdutoSq(Integer produtoSq) {
		this.produtoSq = produtoSq;
	}

	/**
	 * @return the codigoProduto
	 */
	public String getCodigoProduto() {
		return codigoProduto;
	}

	/**
	 * @param codigoProduto
	 *            the codigoProduto to set
	 */
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	/**
	 * @return the descricaoProduto
	 */
	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	/**
	 * @param descricaoProduto
	 *            the descricaoProduto to set
	 */
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	/**
	 * @return the custoMedioProduto
	 */
	public Float getCustoMedioProduto() {
		return custoMedioProduto;
	}

	/**
	 * @param custoMedioProduto
	 *            the custoMedioProduto to set
	 */
	public void setCustoMedioProduto(Float custoMedioProduto) {
		this.custoMedioProduto = custoMedioProduto;
	}

	/**
	 * @return the quantidadeProduto
	 */
	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	/**
	 * @param quantidadeProduto
	 *            the quantidadeProduto to set
	 */
	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

}
