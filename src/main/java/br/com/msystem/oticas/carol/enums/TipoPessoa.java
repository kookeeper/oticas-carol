package br.com.msystem.oticas.carol.enums;

public enum TipoPessoa {
	PESSOA_FISICA("Pessoa Física"), PESSOA_JURIDICA("Pessoa Jurídica");
	
	private String label;
	
	TipoPessoa(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}

}
