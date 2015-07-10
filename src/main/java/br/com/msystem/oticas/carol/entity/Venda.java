package br.com.msystem.oticas.carol.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="venda")
public class Venda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1475759605165416994L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer vendaSq;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVenda;
	private double valorVenda;
	@ManyToOne
	private Pessoa cliente;
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private List<VendaItem> listaItem;
	private String observacao;

	/**
	 * @return the vendaSq
	 */
	public Integer getVendaSq() {
		return vendaSq;
	}

	/**
	 * @param vendaSq the vendaSq to set
	 */
	public void setVendaSq(Integer vendaSq) {
		this.vendaSq = vendaSq;
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
	public double getValorVenda() {
		return valorVenda;
	}

	/**
	 * @param valorVenda
	 *            the valorVenda to set
	 */
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	/**
	 * @return the cliente
	 */
	public Pessoa getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the listaItem
	 */
	public List<VendaItem> getListaItem() {
		if (listaItem == null) {
			listaItem = new ArrayList<VendaItem>();
		}
		return listaItem;
	}

	/**
	 * @param listaItem
	 *            the listaItem to set
	 */
	public void setListaItem(List<VendaItem> listaItem) {
		this.listaItem = listaItem;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao
	 *            the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
