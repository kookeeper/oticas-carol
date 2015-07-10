package br.com.msystem.oticas.carol.util;

import java.io.File;
import java.io.InputStream;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.inf.portalfiscal.nfe.TNFe;

public class NFeUtil {

	public static TNFe abrirNFe(InputStream fileNFe) throws JAXBException {
		JAXBContext context1 = JAXBContext
				.newInstance("br.inf.portalfiscal.nfe");
		Unmarshaller unmarshaller1 = context1.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<TNFe> element = (JAXBElement<TNFe>) unmarshaller1
				.unmarshal(fileNFe);

		return element.getValue();
	}

	public static void main(String[] args) {
		String xml = "/Users/Sergio/workspace/oticas.carol/src/main/resources/nfe.xml";
		if ((new File(xml)).exists()) {
			try {
				JAXBContext context1 = JAXBContext
						.newInstance("br.inf.portalfiscal.nfe");
				Unmarshaller unmarshaller1 = context1.createUnmarshaller();
				@SuppressWarnings("unchecked")
				JAXBElement<TNFe> element = (JAXBElement<TNFe>) unmarshaller1
						.unmarshal(new File(xml));
				// cria o objeto para acessar os nos do XML
				TNFe pegadados = element.getValue();
				// pegar o Nº da NF-e
				String nnf = pegadados.getInfNFe().getIde().getNNF();
				// pegar o Chave de acesso da NF-e
				String id = pegadados.getInfNFe().getId();
				JOptionPane.showMessageDialog(null, "O Numero da NF-e é = "
						+ nnf + " - A Chave de acesso é = " + id);

			} catch (JAXBException e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, xml
					+ " Arquivo não encontrado !", "Erro !",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
