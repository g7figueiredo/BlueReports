package br.com.bluereports.util;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {
	
	private static FacesContext context;
	
    public static Object getSessionMapValue(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
    }

    public static void setSessionMapValue(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
    }
    
    public static void removeSessionMapValue(String key) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
    }

	public static void adicionarMensagem(Severity tipo, String msg) {
		context = FacesContext.getCurrentInstance();
		context.addMessage("msg", new FacesMessage(tipo, msg, msg));
		context.getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public static void adicionarMensagem(Severity tipo, String msg, boolean keep) {
		context = FacesContext.getCurrentInstance();
		context.addMessage("msg", new FacesMessage(tipo, msg, msg));
		context.getExternalContext().getFlash().setKeepMessages(keep);
	}
	
	public static Object getRequestAttribute(String name) {
		context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		return request.getAttribute(name);
	}
	
	public static void redirect(String name) throws IOException {
		context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		externalContext.redirect(name);
	}
	
	public static void putParameterFlash(String name, Object value) {
		context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		externalContext.getFlash().put(name, value);
	}
	
	public static Object getParameterFlash(String name) {
		context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		return externalContext.getFlash().get(name);
	}
	
	public static void removeParameterFlash(String name) {
		context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		externalContext.getFlash().remove(name);
	}
	
}
