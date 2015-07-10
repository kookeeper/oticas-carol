package br.com.msystem.oticas.carol.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendaItem")
public class VendaItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6514067062092658324L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vendaItemSq;
	@ManyToOne
	private Venda venda;
	private Integer numeroItem;
	@ManyToOne
	private Produto produtoItem;
	private Integer quantidadeItem;
	private Float valorUnitarioItem;
	private Float custoUnitarioItem;

	/**
	 * @return the venda
	 */
	public Venda getVenda() {
		return venda;
	}

	/**
	 * @return the vendaItemSq
	 */
	public Integer getVendaItemSq() {
		return vendaItemSq;
	}

	/**
	 * @param vendaItemSq
	 *            the vendaItemSq to set
	 */
	public void setVendaItemSq(Integer vendaItemSq) {
		this.vendaItemSq = vendaItemSq;
	}

	/**
	 * @param venda
	 *            the venda to set
	 */
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	/**
	 * @return the produtoItem
	 */
	public Produto getProdutoItem() {
		return produtoItem;
	}

	/**
	 * @param produtoItem
	 *            the produtoItem to set
	 */
	public void setProdutoItem(Produto produtoItem) {
		this.produtoItem = produtoItem;
	}

	/**
	 * @return the quantidadeItem
	 */
	public Integer getQuantidadeItem() {
		return quantidadeItem;
	}

	/**
	 * @param quantidadeItem
	 *            the quantidadeItem to set
	 */
	public void setQuantidadeItem(Integer quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	/**
	 * @return the valorUnitarioItem
	 */
	public Float getValorUnitarioItem() {
		return valorUnitarioItem;
	}

	/**
	 * @param valorUnitarioItem
	 *            the valorUnitarioItem to set
	 */
	public void setValorUnitarioItem(Float valorUnitarioItem) {
		this.valorUnitarioItem = valorUnitarioItem;
	}

	public Integer getNumeroItem() {
		return numeroItem;
	}

	public void setNumeroItem(Integer numeroItem) {
		this.numeroItem = numeroItem;
	}

	/**
	 * @return the custoUnitarioItem
	 */
	public Float getCustoUnitarioItem() {
		return custoUnitarioItem;
	}

	/**
	 * @param custoUnitarioItem
	 *            the custoUnitarioItem to set
	 */
	public void setCustoUnitarioItem(Float custoUnitarioItem) {
		this.custoUnitarioItem = custoUnitarioItem;
	}

}
