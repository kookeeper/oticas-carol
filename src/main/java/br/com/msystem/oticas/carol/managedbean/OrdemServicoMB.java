package br.com.msystem.oticas.carol.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;

import net.sf.jasperreports.engine.JRException;

import org.primefaces.extensions.util.MessageUtils;

import br.com.msystem.oticas.carol.entity.OrdemServico;
import br.com.msystem.oticas.carol.services.OrdemServicoService;
import br.com.msystem.oticas.carol.util.PDFUtil;

@ManagedBean
@ViewScoped
@Transactional
public class OrdemServicoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7103788064755254928L;
	private Integer numeroOS;
	private List<OrdemServico> listaOS;
	private OrdemServico osSelecionada = new OrdemServico();
	private boolean montagem;

	@ManagedProperty(value = "#{osServiceImpl}")
	private OrdemServicoService osService;

	public String imprimirOS() throws JRException, IOException {

		pesquisarOS();

		if (osSelecionada != null) {
			PDFUtil.imprimirOS(osSelecionada);
			return "sucesso";
		} else {
			return null;
		}
	}

	public void incluirOS(ActionEvent event) {
		osSelecionada = new OrdemServico();
	}

	public void editarOS() {
		System.out.println("Editando OS.");
		setOsSelecionada(new OrdemServico());
	}

	public String gravarOS() {
		osService.salvar(osSelecionada);
		setListaOS(null);

		return null;
	}

	public void pesquisarOSEnvio() {
		pesquisarOS();

		if (getOsSelecionada() != null) {
			if (getOsSelecionada().getDataEnvio() != null) {
				FacesContext.getCurrentInstance().addMessage("",
						MessageUtils.getMessage("os.Enviada"));
			}
		}
	}

	public void pesquisarOSRetorno() {
		pesquisarOS();

		if (getOsSelecionada() != null) {
			if (getOsSelecionada().getDataEnvio() == null) {
				FacesContext.getCurrentInstance().addMessage("",
						MessageUtils.getMessage("os.NaoEnviada"));
				setOsSelecionada(null);
			} else {
				if (getOsSelecionada().getDataRetorno() != null) {
					FacesContext.getCurrentInstance().addMessage("",
							MessageUtils.getMessage("os.Retornou"));
				}
			}
		}
	}

	public void pesquisarOS() {
		setOsSelecionada(osService.buscarPorId(numeroOS));

		if (getOsSelecionada() == null) {
			FacesContext.getCurrentInstance().addMessage("",
					MessageUtils.getMessage("os.NaoEncontrada"));
		}
	}

	public String enviarOS() {
		osService.salvar(getOsSelecionada());

		return "sucesso";
	}

	public String retornarOS() {
		osService.salvar(getOsSelecionada());

		return "sucesso";
	}

	public Integer getNumeroOS() {
		return numeroOS;
	}

	public void setNumeroOS(Integer numeroOS) {
		this.numeroOS = numeroOS;
	}

	public OrdemServicoService getOsService() {
		return osService;
	}

	public void setOsService(OrdemServicoService osService) {
		this.osService = osService;
	}

	public List<OrdemServico> getListaOS() {
		if (listaOS == null) {
			setListaOS(osService.listar());
		}
		return listaOS;
	}

	public void setListaOS(List<OrdemServico> listaOS) {
		this.listaOS = listaOS;
	}

	public OrdemServico getOsSelecionada() {
		return osSelecionada;
	}

	public void setOsSelecionada(OrdemServico osSelecionada) {
		this.osSelecionada = osSelecionada;
	}

	/**
	 * @return the montagem
	 */
	public boolean isMontagem() {
		return montagem;
	}

	/**
	 * @param montagem
	 *            the montagem to set
	 */
	public void setMontagem(boolean montagem) {
		this.montagem = montagem;
	}

}
