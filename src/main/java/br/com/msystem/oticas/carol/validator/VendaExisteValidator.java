package br.com.msystem.oticas.carol.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.extensions.util.MessageUtils;
import org.springframework.web.jsf.FacesContextUtils;

import br.com.msystem.oticas.carol.entity.Venda;
import br.com.msystem.oticas.carol.services.VendaService;

@FacesValidator(value="vendaExisteValidator")
public class VendaExisteValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) {

		VendaService service = FacesContextUtils.getWebApplicationContext(context).getBean(VendaService.class);
		
		Venda venda = service.buscarPorId(((Double)value).intValue());
		
		if (venda == null) {
			throw new ValidatorException(MessageUtils.getMessage("venda.NaoEncontrada"));
		}

	}

}
