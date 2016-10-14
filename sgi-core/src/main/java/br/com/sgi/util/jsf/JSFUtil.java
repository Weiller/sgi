package br.com.sgi.util.jsf;

import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class JSFUtil {
	
	private static String CAMINHO_ARQUIVO_PROPERTIES = "messages.messages";

	public static void addMessage(FacesMessage.Severity severity, String valor) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = ResourceBundle.getBundle(
				CAMINHO_ARQUIVO_PROPERTIES, context.getViewRoot().getLocale());
		String messageBundle = bundle.getString(valor);
		FacesMessage message = new FacesMessage(severity, messageBundle,
				messageBundle);
		context.addMessage(null, message);
	}

	public static void addMessageInfo(String valor) {
		addMessage(FacesMessage.SEVERITY_INFO, valor);
	}

	public static void addMessageWarn(String valor) {
		addMessage(FacesMessage.SEVERITY_WARN, valor);
	}

	public static void addMessageFatal(String valor) {
		addMessage(FacesMessage.SEVERITY_FATAL, valor);
	}

	public static void addMessageError(String valor) {
		addMessage(FacesMessage.SEVERITY_ERROR, valor);
	}

}
