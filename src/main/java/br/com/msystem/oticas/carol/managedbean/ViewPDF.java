/**
 * 
 */
package br.com.msystem.oticas.carol.managedbean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import net.sf.jasperreports.engine.JRException;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.msystem.oticas.carol.entity.Venda;
import br.com.msystem.oticas.carol.services.OrdemServicoService;
import br.com.msystem.oticas.carol.services.VendaService;
import br.com.msystem.oticas.carol.util.PDFUtil;

/**
 * @author Sergio
 *
 */
@ManagedBean
@SessionScoped
public class ViewPDF implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1511315218207706236L;

	@ManagedProperty(value = "#{vendaServiceImpl}")
	private VendaService vendaService;

	@ManagedProperty(value = "#{osServiceImpl}")
	private OrdemServicoService osService;

	/**
	 * @return the streamedContent
	 * @throws IOException
	 * @throws JRException
	 */
	public StreamedContent getRegistroVenda() throws JRException, IOException {

		FacesContext context = FacesContext.getCurrentInstance();

		String param = context.getExternalContext().getRequestParameterMap()
				.get("id");
		System.out.println(param);

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so
			// that it will generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the media. Return a real
			// StreamedContent with the media bytes.
			byte[] conteudo = new byte[0];

			if ((param != null) && (!param.trim().equals(""))) {

				int numeroVenda = new Double(Double.parseDouble(param))
						.intValue();

				Venda venda = vendaService.buscarPorId(numeroVenda);

				conteudo = PDFUtil.imprimirVenda(venda);
			}

			return new DefaultStreamedContent(
					new ByteArrayInputStream(conteudo));
		}

	}

	/**
	 * @return the streamedContent
	 * @throws IOException
	 * @throws JRException
	 */
	public StreamedContent getOrdemServico() throws JRException, IOException {

		FacesContext context = FacesContext.getCurrentInstance();

		String param = context.getExternalContext().getRequestParameterMap()
				.get("id");
		System.out.println(param);

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so
			// that it will generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the media. Return a real
			// StreamedContent with the media bytes.
			byte[] conteudo = new byte[0];

			if ((param != null) && (!param.trim().equals(""))) {

				int numeroOS = new Double(Double.parseDouble(param)).intValue();
				conteudo = PDFUtil.imprimirOS(osService.buscarPorId(numeroOS));
			}

			return new DefaultStreamedContent(
					new ByteArrayInputStream(conteudo));
		}

	}

	/**
	 * @return the vendaService
	 */
	public VendaService getVendaService() {
		return vendaService;
	}

	/**
	 * @param vendaService
	 *            the vendaService to set
	 */
	public void setVendaService(VendaService vendaService) {
		this.vendaService = vendaService;
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
