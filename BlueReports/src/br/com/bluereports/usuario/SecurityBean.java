package br.com.bluereports.usuario;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name="securityBean")
@SessionScoped
public class SecurityBean implements Serializable{
	
	private Usuario usuario;
	
	private static final long serialVersionUID = -9039927336550987989L;

	public String logout() throws IOException{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		
		session.invalidate();
		
		return "restart";
	}
	
	public SecurityBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void redirectUser() throws IOException{
		
		FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        if(request.isUserInRole("ADMIN")){
        	context.getExternalContext().redirect("../relatorio/relatorio_lista.xhtml");
        }
        
        this.usuario = new UsuarioRN().buscarPorEmail(request.getUserPrincipal().getName());
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("USER_SESSION", this.usuario);
	}

	public Usuario getUsuario() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		this.usuario = (Usuario) session.getAttribute("USER_SESSION");
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
