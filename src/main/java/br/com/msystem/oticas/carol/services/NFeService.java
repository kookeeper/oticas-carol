package br.com.msystem.oticas.carol.services;

import java.text.ParseException;

import javax.xml.bind.JAXBException;

import br.com.msystem.oticas.carol.entity.Nfe;

public interface NFeService extends GenericService<Nfe> {
	
	public void importarNFe(byte[] fileContent) throws JAXBException, ParseException;

}
