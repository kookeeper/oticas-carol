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
@Table(name = "nfe")
public class Nfe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6446082217155517501L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer nfeSq;
	private Integer numeroNFe;
	private Float valorNFe;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEmissaoNFe;
	@ManyToOne
	private Pessoa fornecedorNFe;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<NfeItem> listaItemNFe;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Duplicata> listaDuplicata;

	/**
	 * @return the nfeSq
	 */
	public Integer getNfeSq() {
		return nfeSq;
	}

	/**
	 * @param nfeSq
	 *            the nfeSq to set
	 */
	public void setNfeSq(Integer nfeSq) {
		this.nfeSq = nfeSq;
	}

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
	public Pessoa getFornecedorNFe() {
		return fornecedorNFe;
	}

	/**
	 * @param fornecedorNFe
	 *            the fornecedorNFe to set
	 */
	public void setFornecedorNFe(Pessoa fornecedorNFe) {
		this.fornecedorNFe = fornecedorNFe;
	}

	/**
	 * @return the listaItemNFe
	 */
	public List<NfeItem> getListaItemNFe() {
		if (listaItemNFe == null) {
			listaItemNFe = new ArrayList<NfeItem>();
		}
		return listaItemNFe;
	}

	/**
	 * @param listaItemNFe
	 *            the listaItemNFe to set
	 */
	public void setListaItemNFe(List<NfeItem> listaItemNFe) {
		this.listaItemNFe = listaItemNFe;
	}

	/**
	 * @return the listaDuplicata
	 */
	public List<Duplicata> getListaDuplicata() {
		return listaDuplicata;
	}

	/**
	 * @param listaDuplicata
	 *            the listaDuplicata to set
	 */
	public void setListaDuplicata(List<Duplicata> listaDuplicata) {
		this.listaDuplicata = listaDuplicata;
	}

}
