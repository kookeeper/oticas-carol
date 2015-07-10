package br.com.msystem.oticas.carol.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.web.jsf.FacesContextUtils;

import br.com.msystem.oticas.carol.entity.Produto;
import br.com.msystem.oticas.carol.services.ProdutoService;

@FacesConverter(value="produtoConverter")
public class ProdutoConverter implements Converter {

	public ProdutoConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if(value != null && value.trim().length() > 0) {
			ProdutoService service = FacesContextUtils.getWebApplicationContext(context).getBean(ProdutoService.class);
            return service.buscarPorId(Integer.parseInt(value));
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if(value != null) {
            return String.valueOf(((Produto) value).getProdutoSq());
        }
        else {
            return null;
        }
	}

}
