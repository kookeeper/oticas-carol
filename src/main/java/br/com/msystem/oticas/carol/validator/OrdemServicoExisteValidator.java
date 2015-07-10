package br.com.msystem.oticas.carol.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.extensions.util.MessageUtils;
import org.springframework.web.jsf.FacesContextUtils;

import br.com.msystem.oticas.carol.entity.OrdemServico;
import br.com.msystem.oticas.carol.services.OrdemServicoService;

@FacesValidator(value="ordemServicoExisteValidator")
public class OrdemServicoExisteValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) {

		OrdemServicoService service = FacesContextUtils.getWebApplicationContext(context).getBean(OrdemServicoService.class);
		
		OrdemServico os = service.buscarPorId(((Double)value).intValue());
		
		if (os == null) {
			throw new ValidatorException(MessageUtils.getMessage("os.NaoEncontrada"));
		}

	}

}
