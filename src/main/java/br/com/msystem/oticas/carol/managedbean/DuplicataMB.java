package br.com.msystem.oticas.carol.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;

import br.com.msystem.oticas.carol.entity.Duplicata;
import br.com.msystem.oticas.carol.services.DuplicataService;

@ManagedBean
@ViewScoped
@Transactional
public class DuplicataMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -571688318255045747L;
	
	@ManagedProperty(value="#{duplicataServiceImpl}")
	private DuplicataService duplicataService;
	private Duplicata duplicata;
	private List<Duplicata> listaDuplicata;
	private String filtro;

	public void incluir(ActionEvent event) {
		setDuplicata(new Duplicata());
	}
	
	public void editar(Duplicata entity) {
		setDuplicata(entity);
	}
	
	public String gravar() {
		duplicataService.salvar(getDuplicata());
		setListaDuplicata(null);

		return null;
	}
	
	public void filtrar() {
		if ((filtro == null) || (filtro.equals(""))) {
			setListaDuplicata(null);
		} else if (filtro.equals("A")) {
			setListaDuplicata(getDuplicataService().listarEmAberto());
		} else if (filtro.equals("P")) {
			setListaDuplicata(getDuplicataService().listarPagas());
		}
	}

	/**
	 * @return the duplicataService
	 */
	public DuplicataService getDuplicataService() {
		return duplicataService;
	}

	/**
	 * @param duplicataService the duplicataService to set
	 */
	public void setDuplicataService(DuplicataService duplicataService) {
		this.duplicataService = duplicataService;
	}

	/**
	 * @return the duplicata
	 */
	public Duplicata getDuplicata() {
		return duplicata;
	}

	/**
	 * @param duplicata the duplicata to set
	 */
	public void setDuplicata(Duplicata duplicata) {
		this.duplicata = duplicata;
	}

	/**
	 * @param listaDuplicata the listaDuplicata to set
	 */
	public void setListaDuplicata(List<Duplicata> listaDuplicata) {
		this.listaDuplicata = listaDuplicata;
	}

	public List<Duplicata> getListaDuplicata() {
		if (listaDuplicata == null) {
			setListaDuplicata(duplicataService.listar());
		}
		return listaDuplicata;
	}

	/**
	 * @return the filtro
	 */
	public String getFiltro() {
		return filtro;
	}

	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
