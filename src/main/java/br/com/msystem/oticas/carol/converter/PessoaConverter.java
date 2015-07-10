package br.com.msystem.oticas.carol.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.web.jsf.FacesContextUtils;

import br.com.msystem.oticas.carol.entity.Pessoa;
import br.com.msystem.oticas.carol.services.PessoaService;

@FacesConverter(value="pessoaConverter")
public class PessoaConverter implements Converter {

	public PessoaConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if(value != null && value.trim().length() > 0 && !value.equalsIgnoreCase("null")) {
			PessoaService service = FacesContextUtils.getWebApplicationContext(context).getBean(PessoaService.class);
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
            return String.valueOf(((Pessoa) value).getPessoaSq());
        }
        else {
            return null;
        }
	}

}
