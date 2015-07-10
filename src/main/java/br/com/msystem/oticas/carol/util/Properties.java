package br.com.msystem.oticas.carol.util;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class Properties {

	private static ResourceBundle bundle = null;

	public static String getValue(String key) {
		return getBundle().getString(key);
	}

	private static ResourceBundle getBundle() {
		if (bundle == null) {
			bundle = ResourceBundle
					.getBundle("resources.application", FacesContext
							.getCurrentInstance().getViewRoot().getLocale());
		}
		return bundle;
	}

}
