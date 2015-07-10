package br.com.msystem.oticas.carol.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="nfeItem")
public class NfeItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6109185920018631584L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer nfeItemSq;
	@ManyToOne
	private Nfe nfe;
	private Integer numeroItem;
	@ManyToOne(cascade=CascadeType.MERGE)
	private Produto produtoItem;
	private Integer quantidadeItem;
	private Float valorUnitarioItem;

	/**
	 * @return the nfeItemSq
	 */
	public Integer getNfeItemSq() {
		return nfeItemSq;
	}

	/**
	 * @param nfeItemSq the nfeItemSq to set
	 */
	public void setNfeItemSq(Integer nfeItemSq) {
		this.nfeItemSq = nfeItemSq;
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
	 * @return the produtoItem
	 */
	public Produto getProdutoItem() {
		return produtoItem;
	}

	/**
	 * @param produtoItem
	 *            the produtoItem to set
	 */
	public void setProdutoItem(Produto produtoItemNFe) {
		this.produtoItem = produtoItemNFe;
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
	public void setQuantidadeItem(Integer quantidadeItemNFe) {
		this.quantidadeItem = quantidadeItemNFe;
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
	public void setValorUnitarioItem(Float valorUnitarioItemNFe) {
		this.valorUnitarioItem = valorUnitarioItemNFe;
	}

	/**
	 * @return the numeroItem
	 */
	public Integer getNumeroItem() {
		return numeroItem;
	}

	/**
	 * @param numeroItem the numeroItem to set
	 */
	public void setNumeroItem(Integer numeroItemNFe) {
		this.numeroItem = numeroItemNFe;
	}

}
