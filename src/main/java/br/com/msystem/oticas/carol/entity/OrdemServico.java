package br.com.msystem.oticas.carol.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ordemServico")
public class OrdemServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8524648728086939355L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ordemServicoSq;
	@ManyToOne
	private Pessoa laboratorio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEnvio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRetorno;
	private float valorCobrado;
	private float valorCusto;
	@ManyToOne
	@JoinTable(name="nfPagamento_ordemServico", joinColumns={@JoinColumn(name="listaordemservico_ordemservicosq")})
	private NfPagamento nfPagamento;

	private String tipoLente;
	private Boolean comMontagem;
	private Boolean semMontagem;
	private Boolean pronta;
	private Boolean surfacada;
	private String tomColorir;
	private String antiReflexo;
	private String antiRisco;
	private String odLongeEsferico;
	private String odLongeCilindrico;
	private String odLongeEixo;
	private String odLongeAdicao;
	private String odLongeDNP;
	private String odLongeAltura;
	private String oeLongeEsferico;
	private String oeLongeCilindrico;
	private String oeLongeEixo;
	private String oeLongeAdicao;
	private String oeLongeDNP;
	private String oeLongeAltura;
	private String odPertoEsferico;
	private String odPertoCilindrico;
	private String odPertoEixo;
	private String odPertoAdicao;
	private String odPertoDNP;
	private String odPertoAltura;
	private String oePertoEsferico;
	private String oePertoCilindrico;
	private String oePertoEixo;
	private String oePertoAdicao;
	private String oePertoDNP;
	private String oePertoAltura;
	private String medidaLenteHorizontal;
	private String medidaLenteVertical;
	private String medidaLentePonte;
	private String medidaLenteDiagonal;
	private Boolean acetato;
	private Boolean metal;
	private Boolean nylon;
	private Boolean fioAco;
	private Boolean baugriff;
	private Boolean oculosSeguranca;
	private String observacao;

	/**
	 * @return the ordemServicoSq
	 */
	public Integer getOrdemServicoSq() {
		return ordemServicoSq;
	}

	/**
	 * @param ordemServicoSq
	 *            the ordemServicoSq to set
	 */
	public void setOrdemServicoSq(Integer ordemServicoSq) {
		this.ordemServicoSq = ordemServicoSq;
	}

	/**
	 * @return the laboratorio
	 */
	public Pessoa getLaboratorio() {
		return laboratorio;
	}

	/**
	 * @param laboratorio
	 *            the laboratorio to set
	 */
	public void setLaboratorio(Pessoa laboratorio) {
		this.laboratorio = laboratorio;
	}

	/**
	 * @return the dataEnvio
	 */
	public Date getDataEnvio() {
		return dataEnvio;
	}

	/**
	 * @param dataEnvio
	 *            the dataEnvio to set
	 */
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	/**
	 * @return the dataRetorno
	 */
	public Date getDataRetorno() {
		return dataRetorno;
	}

	/**
	 * @param dataRetorno
	 *            the dataRetorno to set
	 */
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	/**
	 * @return the valorCobrado
	 */
	public float getValorCobrado() {
		return valorCobrado;
	}

	/**
	 * @param valorCobrado
	 *            the valorCobrado to set
	 */
	public void setValorCobrado(float valorCobrado) {
		this.valorCobrado = valorCobrado;
	}

	/**
	 * @return the valorCusto
	 */
	public float getValorCusto() {
		return valorCusto;
	}

	/**
	 * @param valorCusto
	 *            the valorCusto to set
	 */
	public void setValorCusto(float valorCusto) {
		this.valorCusto = valorCusto;
	}

	/**
	 * @return the nfPagamento
	 */
	public NfPagamento getNfPagamento() {
		return nfPagamento;
	}

	/**
	 * @param nfPagamento
	 *            the nfPagamento to set
	 */
	public void setNfPagamento(NfPagamento nfPagamento) {
		this.nfPagamento = nfPagamento;
	}

	/**
	 * @return the tipoLente
	 */
	public String getTipoLente() {
		return tipoLente;
	}

	/**
	 * @param tipoLente
	 *            the tipoLente to set
	 */
	public void setTipoLente(String tipoLente) {
		this.tipoLente = tipoLente;
	}

	/**
	 * @return the comMontagem
	 */
	public Boolean getComMontagem() {
		return comMontagem;
	}

	/**
	 * @param comMontagem
	 *            the comMontagem to set
	 */
	public void setComMontagem(Boolean comMontagem) {
		this.comMontagem = comMontagem;
	}

	/**
	 * @return the semMontagem
	 */
	public Boolean getSemMontagem() {
		return semMontagem;
	}

	/**
	 * @param semMontagem
	 *            the semMontagem to set
	 */
	public void setSemMontagem(Boolean semMontagem) {
		this.semMontagem = semMontagem;
	}

	/**
	 * @return the pronta
	 */
	public Boolean getPronta() {
		return pronta;
	}

	/**
	 * @param pronta
	 *            the pronta to set
	 */
	public void setPronta(Boolean pronta) {
		this.pronta = pronta;
	}

	/**
	 * @return the surfacada
	 */
	public Boolean getSurfacada() {
		return surfacada;
	}

	/**
	 * @param surfacada
	 *            the surfacada to set
	 */
	public void setSurfacada(Boolean surfacada) {
		this.surfacada = surfacada;
	}

	/**
	 * @return the tomColorir
	 */
	public String getTomColorir() {
		return tomColorir;
	}

	/**
	 * @param tomColorir
	 *            the tomColorir to set
	 */
	public void setTomColorir(String tomColorir) {
		this.tomColorir = tomColorir;
	}

	/**
	 * @return the antiReflexo
	 */
	public String getAntiReflexo() {
		return antiReflexo;
	}

	/**
	 * @param antiReflexo
	 *            the antiReflexo to set
	 */
	public void setAntiReflexo(String antiReflexo) {
		this.antiReflexo = antiReflexo;
	}

	/**
	 * @return the antiRisco
	 */
	public String getAntiRisco() {
		return antiRisco;
	}

	/**
	 * @param antiRisco
	 *            the antiRisco to set
	 */
	public void setAntiRisco(String antiRisco) {
		this.antiRisco = antiRisco;
	}

	/**
	 * @return the odLongeEsferico
	 */
	public String getOdLongeEsferico() {
		return odLongeEsferico;
	}

	/**
	 * @param odLongeEsferico
	 *            the odLongeEsferico to set
	 */
	public void setOdLongeEsferico(String odLongeEsferico) {
		this.odLongeEsferico = odLongeEsferico;
	}

	/**
	 * @return the odLongeCilindrico
	 */
	public String getOdLongeCilindrico() {
		return odLongeCilindrico;
	}

	/**
	 * @param odLongeCilindrico
	 *            the odLongeCilindrico to set
	 */
	public void setOdLongeCilindrico(String odLongeCilindrico) {
		this.odLongeCilindrico = odLongeCilindrico;
	}

	/**
	 * @return the odLongeEixo
	 */
	public String getOdLongeEixo() {
		return odLongeEixo;
	}

	/**
	 * @param odLongeEixo
	 *            the odLongeEixo to set
	 */
	public void setOdLongeEixo(String odLongeEixo) {
		this.odLongeEixo = odLongeEixo;
	}

	/**
	 * @return the odLongeAdicao
	 */
	public String getOdLongeAdicao() {
		return odLongeAdicao;
	}

	/**
	 * @param odLongeAdicao
	 *            the odLongeAdicao to set
	 */
	public void setOdLongeAdicao(String odLongeAdicao) {
		this.odLongeAdicao = odLongeAdicao;
	}

	/**
	 * @return the odLongeDNP
	 */
	public String getOdLongeDNP() {
		return odLongeDNP;
	}

	/**
	 * @param odLongeDNP
	 *            the odLongeDNP to set
	 */
	public void setOdLongeDNP(String odLongeDNP) {
		this.odLongeDNP = odLongeDNP;
	}

	/**
	 * @return the odLongeAltura
	 */
	public String getOdLongeAltura() {
		return odLongeAltura;
	}

	/**
	 * @param odLongeAltura
	 *            the odLongeAltura to set
	 */
	public void setOdLongeAltura(String odLongeAltura) {
		this.odLongeAltura = odLongeAltura;
	}

	/**
	 * @return the oeLongeEsferico
	 */
	public String getOeLongeEsferico() {
		return oeLongeEsferico;
	}

	/**
	 * @param oeLongeEsferico
	 *            the oeLongeEsferico to set
	 */
	public void setOeLongeEsferico(String oeLongeEsferico) {
		this.oeLongeEsferico = oeLongeEsferico;
	}

	/**
	 * @return the oeLongeCilindrico
	 */
	public String getOeLongeCilindrico() {
		return oeLongeCilindrico;
	}

	/**
	 * @param oeLongeCilindrico
	 *            the oeLongeCilindrico to set
	 */
	public void setOeLongeCilindrico(String oeLongeCilindrico) {
		this.oeLongeCilindrico = oeLongeCilindrico;
	}

	/**
	 * @return the oeLongeEixo
	 */
	public String getOeLongeEixo() {
		return oeLongeEixo;
	}

	/**
	 * @param oeLongeEixo
	 *            the oeLongeEixo to set
	 */
	public void setOeLongeEixo(String oeLongeEixo) {
		this.oeLongeEixo = oeLongeEixo;
	}

	/**
	 * @return the oeLongeAdicao
	 */
	public String getOeLongeAdicao() {
		return oeLongeAdicao;
	}

	/**
	 * @param oeLongeAdicao
	 *            the oeLongeAdicao to set
	 */
	public void setOeLongeAdicao(String oeLongeAdicao) {
		this.oeLongeAdicao = oeLongeAdicao;
	}

	/**
	 * @return the oeLongeDNP
	 */
	public String getOeLongeDNP() {
		return oeLongeDNP;
	}

	/**
	 * @param oeLongeDNP
	 *            the oeLongeDNP to set
	 */
	public void setOeLongeDNP(String oeLongeDNP) {
		this.oeLongeDNP = oeLongeDNP;
	}

	/**
	 * @return the oeLongeAltura
	 */
	public String getOeLongeAltura() {
		return oeLongeAltura;
	}

	/**
	 * @param oeLongeAltura
	 *            the oeLongeAltura to set
	 */
	public void setOeLongeAltura(String oeLongeAltura) {
		this.oeLongeAltura = oeLongeAltura;
	}

	/**
	 * @return the odPertoEsferico
	 */
	public String getOdPertoEsferico() {
		return odPertoEsferico;
	}

	/**
	 * @param odPertoEsferico
	 *            the odPertoEsferico to set
	 */
	public void setOdPertoEsferico(String odPertoEsferico) {
		this.odPertoEsferico = odPertoEsferico;
	}

	/**
	 * @return the odPertoCilindrico
	 */
	public String getOdPertoCilindrico() {
		return odPertoCilindrico;
	}

	/**
	 * @param odPertoCilindrico
	 *            the odPertoCilindrico to set
	 */
	public void setOdPertoCilindrico(String odPertoCilindrico) {
		this.odPertoCilindrico = odPertoCilindrico;
	}

	/**
	 * @return the odPertoEixo
	 */
	public String getOdPertoEixo() {
		return odPertoEixo;
	}

	/**
	 * @param odPertoEixo
	 *            the odPertoEixo to set
	 */
	public void setOdPertoEixo(String odPertoEixo) {
		this.odPertoEixo = odPertoEixo;
	}

	/**
	 * @return the odPertoAdicao
	 */
	public String getOdPertoAdicao() {
		return odPertoAdicao;
	}

	/**
	 * @param odPertoAdicao
	 *            the odPertoAdicao to set
	 */
	public void setOdPertoAdicao(String odPertoAdicao) {
		this.odPertoAdicao = odPertoAdicao;
	}

	/**
	 * @return the odPertoDNP
	 */
	public String getOdPertoDNP() {
		return odPertoDNP;
	}

	/**
	 * @param odPertoDNP
	 *            the odPertoDNP to set
	 */
	public void setOdPertoDNP(String odPertoDNP) {
		this.odPertoDNP = odPertoDNP;
	}

	/**
	 * @return the odPertoAltura
	 */
	public String getOdPertoAltura() {
		return odPertoAltura;
	}

	/**
	 * @param odPertoAltura
	 *            the odPertoAltura to set
	 */
	public void setOdPertoAltura(String odPertoAltura) {
		this.odPertoAltura = odPertoAltura;
	}

	/**
	 * @return the oePertoEsferico
	 */
	public String getOePertoEsferico() {
		return oePertoEsferico;
	}

	/**
	 * @param oePertoEsferico
	 *            the oePertoEsferico to set
	 */
	public void setOePertoEsferico(String oePertoEsferico) {
		this.oePertoEsferico = oePertoEsferico;
	}

	/**
	 * @return the oePertoCilindrico
	 */
	public String getOePertoCilindrico() {
		return oePertoCilindrico;
	}

	/**
	 * @param oePertoCilindrico
	 *            the oePertoCilindrico to set
	 */
	public void setOePertoCilindrico(String oePertoCilindrico) {
		this.oePertoCilindrico = oePertoCilindrico;
	}

	/**
	 * @return the oePertoEixo
	 */
	public String getOePertoEixo() {
		return oePertoEixo;
	}

	/**
	 * @param oePertoEixo
	 *            the oePertoEixo to set
	 */
	public void setOePertoEixo(String oePertoEixo) {
		this.oePertoEixo = oePertoEixo;
	}

	/**
	 * @return the oePertoAdicao
	 */
	public String getOePertoAdicao() {
		return oePertoAdicao;
	}

	/**
	 * @param oePertoAdicao
	 *            the oePertoAdicao to set
	 */
	public void setOePertoAdicao(String oePertoAdicao) {
		this.oePertoAdicao = oePertoAdicao;
	}

	/**
	 * @return the oePertoDNP
	 */
	public String getOePertoDNP() {
		return oePertoDNP;
	}

	/**
	 * @param oePertoDNP
	 *            the oePertoDNP to set
	 */
	public void setOePertoDNP(String oePertoDNP) {
		this.oePertoDNP = oePertoDNP;
	}

	/**
	 * @return the oePertoAltura
	 */
	public String getOePertoAltura() {
		return oePertoAltura;
	}

	/**
	 * @param oePertoAltura
	 *            the oePertoAltura to set
	 */
	public void setOePertoAltura(String oePertoAltura) {
		this.oePertoAltura = oePertoAltura;
	}

	/**
	 * @return the medidaLenteHorizontal
	 */
	public String getMedidaLenteHorizontal() {
		return medidaLenteHorizontal;
	}

	/**
	 * @param medidaLenteHorizontal
	 *            the medidaLenteHorizontal to set
	 */
	public void setMedidaLenteHorizontal(String medidaLenteHorizontal) {
		this.medidaLenteHorizontal = medidaLenteHorizontal;
	}

	/**
	 * @return the medidaLenteVertical
	 */
	public String getMedidaLenteVertical() {
		return medidaLenteVertical;
	}

	/**
	 * @param medidaLenteVertical
	 *            the medidaLenteVertical to set
	 */
	public void setMedidaLenteVertical(String medidaLenteVertical) {
		this.medidaLenteVertical = medidaLenteVertical;
	}

	/**
	 * @return the medidaLentePonte
	 */
	public String getMedidaLentePonte() {
		return medidaLentePonte;
	}

	/**
	 * @param medidaLentePonte
	 *            the medidaLentePonte to set
	 */
	public void setMedidaLentePonte(String medidaLentePonte) {
		this.medidaLentePonte = medidaLentePonte;
	}

	/**
	 * @return the medidaLenteDiagonal
	 */
	public String getMedidaLenteDiagonal() {
		return medidaLenteDiagonal;
	}

	/**
	 * @param medidaLenteDiagonal
	 *            the medidaLenteDiagonal to set
	 */
	public void setMedidaLenteDiagonal(String medidaLenteDiagonal) {
		this.medidaLenteDiagonal = medidaLenteDiagonal;
	}

	/**
	 * @return the acetato
	 */
	public Boolean getAcetato() {
		return acetato;
	}

	/**
	 * @param acetato
	 *            the acetato to set
	 */
	public void setAcetato(Boolean acetato) {
		this.acetato = acetato;
	}

	/**
	 * @return the metal
	 */
	public Boolean getMetal() {
		return metal;
	}

	/**
	 * @param metal
	 *            the metal to set
	 */
	public void setMetal(Boolean metal) {
		this.metal = metal;
	}

	/**
	 * @return the nylon
	 */
	public Boolean getNylon() {
		return nylon;
	}

	/**
	 * @param nylon
	 *            the nylon to set
	 */
	public void setNylon(Boolean nylon) {
		this.nylon = nylon;
	}

	/**
	 * @return the fioAco
	 */
	public Boolean getFioAco() {
		return fioAco;
	}

	/**
	 * @param fioAco
	 *            the fioAco to set
	 */
	public void setFioAco(Boolean fioAco) {
		this.fioAco = fioAco;
	}

	/**
	 * @return the baugriff
	 */
	public Boolean getBaugriff() {
		return baugriff;
	}

	/**
	 * @param baugriff
	 *            the baugriff to set
	 */
	public void setBaugriff(Boolean baugriff) {
		this.baugriff = baugriff;
	}

	/**
	 * @return the oculosSeguranca
	 */
	public Boolean getOculosSeguranca() {
		return oculosSeguranca;
	}

	/**
	 * @param oculosSeguranca
	 *            the oculosSeguranca to set
	 */
	public void setOculosSeguranca(Boolean oculosSeguranca) {
		this.oculosSeguranca = oculosSeguranca;
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
