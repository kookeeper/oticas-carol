package br.com.msystem.oticas.carol.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.primefaces.event.RowEditEvent;
import org.primefaces.extensions.util.MessageUtils;

import br.com.msystem.oticas.carol.entity.NfPagamento;
import br.com.msystem.oticas.carol.entity.OrdemServico;
import br.com.msystem.oticas.carol.services.NfPagamentoService;
import br.com.msystem.oticas.carol.services.OrdemServicoService;

@ManagedBean
@ViewScoped
@Transactional
public class NfPagamentoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7103788064755254928L;

	@ManagedProperty(value = "#{nfPagamentoServiceImpl}")
	private NfPagamentoService nfPagamentoService;

	@ManagedProperty(value = "#{osServiceImpl}")
	private OrdemServicoService osService;

	private NfPagamento nfPagamento;

	public String salvar() {
		nfPagamentoService.salvar(getNfPagamento());
		return "sucesso";
	}

	public void salvarOS(RowEditEvent event) {

		OrdemServico os = osService.buscarPorId(((OrdemServico) event
				.getObject()).getOrdemServicoSq());

		if (os == null) {
			FacesContext.getCurrentInstance().addMessage("",
					MessageUtils.getMessage("os.NaoEncontrada"));
		} else {
			nfPagamento.getListaOrdemServico().add(os);
		}
	}

	public void adicionarOS(Integer ordemServicoSq) {

		OrdemServico os = osService.buscarPorId(ordemServicoSq);

		if (os == null) {
			FacesContext.getCurrentInstance().addMessage("",
					MessageUtils.getMessage("os.NaoEncontrada"));
			FacesContext.getCurrentInstance().validationFailed();
		} else if (os.getDataEnvio() == null) {
			FacesContext.getCurrentInstance().addMessage("",
					MessageUtils.getMessage("os.NaoEnviada"));
			FacesContext.getCurrentInstance().validationFailed();
		} else if (os.getDataRetorno() == null) {
			FacesContext.getCurrentInstance().addMessage("",
					MessageUtils.getMessage("os.NaoRetornada"));
			FacesContext.getCurrentInstance().validationFailed();
		} else {

			if (os.getNfPagamento() != null) {

				FacesContext.getCurrentInstance().addMessage(
						"",
						MessageUtils.getMessage("os.Incluida", os.getNfPagamento().getNumero()));
				FacesContext.getCurrentInstance().validationFailed();

			} else {
				nfPagamento.getListaOrdemServico().add(os);
			}
		}
	}

	public double getSomatoriaOS() {
		double l = 0;

		for (OrdemServico os : getNfPagamento().getListaOrdemServico()) {
			l += os.getValorCusto();
		}

		return l;
	}

	public double getValorRestanteOS() {
		float l = getNfPagamento().getValor();

		for (OrdemServico os : getNfPagamento().getListaOrdemServico()) {
			l = l - os.getValorCusto();
		}

		return l;
	}

	public void removerOS(OrdemServico os) {
		nfPagamento.getListaOrdemServico().remove(os);
	}

	/**
	 * @return the nfPagamento
	 */
	public NfPagamento getNfPagamento() {
		if (nfPagamento == null) {
			setNfPagamento(new NfPagamento());
		}
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
	 * @return the nfPagamentoService
	 */
	public NfPagamentoService getNfPagamentoService() {
		return nfPagamentoService;
	}

	/**
	 * @param nfPagamentoService
	 *            the nfPagamentoService to set
	 */
	public void setNfPagamentoService(NfPagamentoService nfPagamentoService) {
		this.nfPagamentoService = nfPagamentoService;
	}

	/**
	 * @return the osService
	 */
	public OrdemServicoService getOsService() {
		return osService;
	}

	/**
	 * @param osService
	 *            the osService to set
	 */
	public void setOsService(OrdemServicoService osService) {
		this.osService = osService;
	}

}
