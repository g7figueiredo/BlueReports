package br.com.bluereports.relatorio;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name="imagemRelatorioBean")
@SessionScoped
public class ImagemRelatorioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 560304226573139936L;
	
	private Relatorio relatorio;
	
	@PostConstruct
	public void init() {
		this.relatorio = new Relatorio();
	}
	
	public StreamedContent getConteudoImagem() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE)
				return (StreamedContent) new DefaultStreamedContent();
			String idS = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
			String param = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("select");
			int id = Integer.parseInt(idS);
			this.relatorio = new RelatorioRN().buscarPorId(id);
			InputStream is = null;
			switch (param) {
			case "1": is = new ByteArrayInputStream(relatorio.getImg1()); break;
			case "2": is = new ByteArrayInputStream(relatorio.getImg2()); break;
			case "3": is = new ByteArrayInputStream(relatorio.getImg3()); break;
			case "4": is = new ByteArrayInputStream(relatorio.getImg4()); break;
			default: break;
			}
			DefaultStreamedContent dsc = new DefaultStreamedContent(is);
			return dsc;
		} catch (Exception e) {
			return (StreamedContent) new DefaultStreamedContent();
		}
	}
	
}
