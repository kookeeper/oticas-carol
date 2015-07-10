package br.com.msystem.oticas.carol.managedbean;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.transaction.Transactional;

import br.com.msystem.oticas.carol.bean.ResumoVenda;
import br.com.msystem.oticas.carol.entity.Venda;
import br.com.msystem.oticas.carol.entity.VendaItem;
import br.com.msystem.oticas.carol.services.VendaService;

@ManagedBean
@ViewScoped
@Transactional
public class VendaMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 563981821742791340L;
	private Long numeroVenda;
	private List<Venda> listaVenda;
	private List<ResumoVenda> listaResumoVenda;
	private Venda vendaSelecionada;
	private VendaItem itemVendaSelecionado;

	@ManagedProperty(value = "#{vendaServiceImpl}")
	private VendaService vendaService;

	public String editarVenda() {
		return null;
	}

	public String gravarVenda() {

		for (VendaItem item : vendaSelecionada.getListaItem()) {
			if (item.getVendaItemSq() < 0) {
				item.setVendaItemSq(null);
			}
		}

		vendaService.salvar(vendaSelecionada);
		setListaVenda(null);

		return null;
	}

	public void incluirItem(ActionEvent event) {
		setItemVendaSelecionado(new VendaItem());
	}

	public void incluirVenda(ActionEvent event) {
		setVendaSelecionada(new Venda());
	}

	public void atualizaPrecoCusto() {
		getItemVendaSelecionado().setCustoUnitarioItem(
				getItemVendaSelecionado().getProdutoItem()
						.getCustoMedioProduto());
	}

	private void atualizarValorVenda() {
		getVendaSelecionada().setValorVenda(0);
		for (VendaItem item : vendaSelecionada.getListaItem()) {
			getVendaSelecionada().setValorVenda(
					getVendaSelecionada().getValorVenda()
							+ (item.getValorUnitarioItem() * item
									.getQuantidadeItem()));
		}
	}

	public String gravarItem() {

		if (itemVendaSelecionado.getVendaItemSq() == null) {
			getItemVendaSelecionado().setVendaItemSq(
					-1 * getItemVendaSelecionado().hashCode());
			if (getVendaSelecionada().getListaItem().size() == 0) {
				getItemVendaSelecionado().setNumeroItem(1);
			} else {
				getItemVendaSelecionado().setNumeroItem(
						getVendaSelecionada()
								.getListaItem()
								.get(getVendaSelecionada().getListaItem()
										.size() - 1).getNumeroItem() + 1);
			}
			getItemVendaSelecionado().setVenda(vendaSelecionada);
			vendaSelecionada.getListaItem().add(getItemVendaSelecionado());
		} else {
			for (VendaItem item : vendaSelecionada.getListaItem()) {
				if (item.getVendaItemSq().equals(
						itemVendaSelecionado.getVendaItemSq())) {
					vendaSelecionada.getListaItem().remove(item);
					vendaSelecionada.getListaItem().add(itemVendaSelecionado);
					break;
				}
			}
		}

		atualizarValorVenda();

		return null;
	}

	public void excluirItem(VendaItem item) {

		for (VendaItem entity : vendaSelecionada.getListaItem()) {
			if (entity.getVendaItemSq().equals(item.getVendaItemSq())) {
				vendaSelecionada.getListaItem().remove(entity);
				break;
			}
		}

		atualizarValorVenda();

	}

	public void filtrarResumoVenda(Date dataInicial, Date dataFinal) {
		
		if (dataInicial == null) {
			if (dataFinal == null) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					dataInicial = sdf.parse(sdf.format(new Date()));
				} catch (ParseException e) {
					dataInicial = null;
				}
			} else {
				dataInicial = dataFinal;
			}
		}
		
		if (dataFinal == null) {
			dataFinal = dataInicial;
		}
		
		setListaResumoVenda(vendaService.listarResumoVenda(dataInicial,
				dataFinal));
	}

	public String getTotalValorVenda() {
		Double total = 0d;

		if (getListaResumoVenda() != null) {
			for (ResumoVenda bean : getListaResumoVenda()) {
				total += bean.getValorVenda();
			}
		}
		return NumberFormat.getCurrencyInstance().format(total);
	}

	public String getTotalValorCusto() {
		Double total = 0d;

		if (getListaResumoVenda() != null) {
			for (ResumoVenda bean : getListaResumoVenda()) {
				if (bean.getValorCusto() != null) {
					total += bean.getValorCusto();
				}
			}
		}

		return NumberFormat.getCurrencyInstance().format(total);
	}

	public String getTotalLucratividade() {
		Double total = 0d;

		if (getListaResumoVenda() != null) {
			for (ResumoVenda bean : getListaResumoVenda()) {
				if ((bean.getValorVenda() != null) && (bean.getValorCusto() != null)) {
					total += (bean.getValorVenda() - bean.getValorCusto());
				}
			}
		}

		return NumberFormat.getCurrencyInstance().format(total);
	}

	public Long getNumeroVenda() {
		return numeroVenda;
	}

	public void setNumeroVenda(Long numeroVenda) {
		this.numeroVenda = numeroVenda;
	}

	public List<Venda> getListaVenda() {
		if (listaVenda == null) {
			setListaVenda(vendaService.listar());
		}
		return listaVenda;
	}

	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}

	public VendaService getVendaService() {
		return vendaService;
	}

	public void setVendaService(VendaService vendaService) {
		this.vendaService = vendaService;
	}

	public Venda getVendaSelecionada() {
		return vendaSelecionada;
	}

	public void setVendaSelecionada(Venda vendaSelecionada) {
		this.vendaSelecionada = vendaSelecionada;
	}

	public VendaItem getItemVendaSelecionado() {
		return itemVendaSelecionado;
	}

	public void setItemVendaSelecionado(VendaItem itemVendaSelecionado) {
		this.itemVendaSelecionado = itemVendaSelecionado;
	}

	/**
	 * @return the listaResumoVenda
	 */
	public List<ResumoVenda> getListaResumoVenda() {
		return listaResumoVenda;
	}

	/**
	 * @param listaResumoVenda
	 *            the listaResumoVenda to set
	 */
	public void setListaResumoVenda(List<ResumoVenda> listaResumoVenda) {
		this.listaResumoVenda = listaResumoVenda;
	}

}
