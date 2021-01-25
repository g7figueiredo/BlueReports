package br.com.bluereports.usuario;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 5661856551917920503L;
	
	private Usuario usuarioLogado;
	
	public UsuarioBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		this.usuarioLogado = new UsuarioRN().buscarPorEmail(request.getUserPrincipal().getName());
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
