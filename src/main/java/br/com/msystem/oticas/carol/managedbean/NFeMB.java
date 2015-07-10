package br.com.msystem.oticas.carol.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.event.SelectEvent;
import org.primefaces.extensions.util.MessageUtils;
import org.primefaces.model.UploadedFile;

import br.com.msystem.oticas.carol.entity.Nfe;
import br.com.msystem.oticas.carol.entity.NfeItem;
import br.com.msystem.oticas.carol.services.NFeService;
import br.com.msystem.oticas.carol.util.Util;

@ManagedBean
@ViewScoped
@Transactional
public class NFeMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6770151581597992533L;

	@ManagedProperty(value = "#{nfeServiceImpl}")
	private NFeService nfeService;

	private UploadedFile file;
	private List<Nfe> listaNFe;
	private Nfe nfeSelecionada;
	private NfeItem itemSelecionado;
	private Integer nfeSq;

	public String editarNFe() {
		setNfeSelecionada(nfeService.buscarPorId(getNfeSq()));
		return null;
	}

	public String importarNFe() throws IOException, JAXBException,
			ParseException {

		nfeService.importarNFe(IOUtils.toByteArray(file.getInputstream()));

		FacesContext context = FacesContext.getCurrentInstance();
		Flash flash = context.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		context.addMessage("",
				MessageUtils.getMessage("nfe.importadaComSucesso"));

		return "sucesso";
	}

	public void selecionarLinha(SelectEvent event) {
		setNfeSelecionada((Nfe) event.getObject());

	}

	public void editarLinha(SelectEvent event) {
		System.out.println("Editando registro "
				+ getNfeSelecionada().getNumeroNFe());
		CommandButton cb1 = (CommandButton) Util.findComponent("cb1");
		ActionEvent e = new ActionEvent(cb1);
		e.queue();

	}

	public String gravarItem() {

		if (itemSelecionado.getNfeItemSq() == null) {
			getItemSelecionado().setNfeItemSq(
					-1 * getItemSelecionado().hashCode());
			if (getNfeSelecionada().getListaItemNFe().size() == 0) {
				getItemSelecionado().setNumeroItem(1);
			} else {
				getItemSelecionado().setNumeroItem(
						getNfeSelecionada()
								.getListaItemNFe()
								.get(getNfeSelecionada().getListaItemNFe()
										.size() - 1).getNumeroItem() + 1);
			}
			getItemSelecionado().setNfe(nfeSelecionada);
			nfeSelecionada.getListaItemNFe().add(itemSelecionado);
		} else {
			for (NfeItem item : nfeSelecionada.getListaItemNFe()) {
				if (item.getNfeItemSq().equals(itemSelecionado.getNfeItemSq())) {
					nfeSelecionada.getListaItemNFe().remove(item);
					nfeSelecionada.getListaItemNFe().add(itemSelecionado);
					break;
				}
			}
		}

		return null;
	}

	public String gravarNFe() {

		for (NfeItem item : nfeSelecionada.getListaItemNFe()) {
			if (item.getNfeItemSq() < 0) {
				item.setNfeItemSq(null);
			}
		}

		nfeService.salvar(getNfeSelecionada());
		setListaNFe(null);

		return null;
	}

	public void incluirNFe(ActionEvent event) {
		setNfeSelecionada(new Nfe());
	}

	public void incluirItem(ActionEvent event) {
		setItemSelecionado(new NfeItem());
	}

	public void excluirItem(NfeItem item) {

		for (NfeItem entity : nfeSelecionada.getListaItemNFe()) {
			if (entity.getNfeItemSq().equals(item.getNfeItemSq())) {
				nfeSelecionada.getListaItemNFe().remove(entity);
				break;
			}
		}

	}

	public NFeService getNfeService() {
		return nfeService;
	}

	public void setNfeService(NFeService nfeService) {
		this.nfeService = nfeService;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<Nfe> getListaNFe() {
		if (listaNFe == null) {
			setListaNFe(nfeService.listar());
		}
		return listaNFe;
	}

	public void setListaNFe(List<Nfe> listaNFe) {
		this.listaNFe = listaNFe;
	}

	public Nfe getNfeSelecionada() {
		return nfeSelecionada;
	}

	public void setNfeSelecionada(Nfe nfeSelecionada) {
		this.nfeSelecionada = nfeSelecionada;
	}

	public Integer getNumeroNFe() {
		return null;
	}

	public void setNumeroNFe(Integer numeroNFe) {
		setNfeSelecionada(nfeService.buscarPorId(numeroNFe));
	}

	public NfeItem getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(NfeItem itemNFeSelecionado) {
		this.itemSelecionado = itemNFeSelecionado;
	}

	public Integer getNfeSq() {
		return nfeSq;
	}

	public void setNfeSq(Integer id) {
		nfeSq = id;
	}

}
