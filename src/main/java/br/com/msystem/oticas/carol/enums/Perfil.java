package br.com.msystem.oticas.carol.enums;

public enum Perfil {
	VENDEDOR("Vendedor"), GERENTE("Gerente"), MASTER("Master");

	private String label;

	private Perfil(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
