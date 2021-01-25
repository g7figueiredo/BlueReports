package br.com.bluereports.relatorio;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PostPersist;

import org.primefaces.event.FileUploadEvent;

import br.com.bluereports.cliente.Cliente;
import br.com.bluereports.cliente.ClienteRN;
import br.com.bluereports.util.FacesUtil;

@ManagedBean(name="relatorioBean")
@ViewScoped
public class RelatorioBean implements Serializable{
	
	private static final long serialVersionUID = -2788573407312247549L;
	
	private Relatorio relatorio = new Relatorio();
	private List<Relatorio> listaRelatorio = new ArrayList<Relatorio>();
	
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	private boolean exibirFotos = false;
	
	public RelatorioBean() {
		// TODO Auto-generated constructor stub
		listarTodos();
		Relatorio r = (Relatorio) FacesUtil.getSessionMapValue("relatorio");
		if(r != null && r.getIdRelatorio() > 0) {
			this.relatorio = r;
			FacesUtil.removeSessionMapValue("relatorio");
		}
	}
	
	public String visualizarRelatorio() throws IOException {
		if(this.relatorio == null || this.relatorio.getIdRelatorio() <= 0) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_WARN, "Clique para selecionar um item!");
		}else {
			FacesUtil.setSessionMapValue("relatorio", this.relatorio);
			FacesUtil.redirect("report.xhtml");
		}
		return "";
	}
	
	public String imprimirRelatorio() throws IOException {
		if(this.relatorio != null || this.relatorio.getIdRelatorio() > 0) {
			FacesUtil.setSessionMapValue("relatorio", this.relatorio);
			FacesUtil.redirect("report-print.xhtml");
		}else {
			System.out.println("null");
		}
		
		return "";
		
	}
	
	@PostPersist
	private void limpar(){
		this.relatorio = new Relatorio();
		this.listaRelatorio =new ArrayList<Relatorio>();
	}
	
	public String salvar() throws IOException{
		RelatorioRN relatorioRN = new RelatorioRN();
		relatorio.setStatusCad("A");
		
		relatorioRN.salvar(relatorio);

		FacesMessage message = new FacesMessage("Relatório salvo com sucesso!");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
		
		limpar();
		FacesUtil.redirect("relatorio_lista.xhtml");
		return "";
	}
	
	public void listarTodos(){
		RelatorioRN relatorioRN = new RelatorioRN();
		this.listaRelatorio = relatorioRN.listaRelatorio();
	}

	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	public List<Relatorio> getListaRelatorio() {
		return listaRelatorio;
	}

	public void setListaRelatorio(List<Relatorio> listaRelatorio) {
		this.listaRelatorio = listaRelatorio;
	}

	public List<Cliente> getListaCliente() {
		ClienteRN clienteRN = new ClienteRN();
		this.listaCliente = clienteRN.listaCliente();
		return listaCliente;
	}
	
	public void fileUpload(FileUploadEvent event) throws IOException{
		try	 {
			 byte[] bimagem = event.getFile().getContents();
			 String id = event.getComponent().getId();
			 if(id.equals("image1")) {
				 this.relatorio.setImg1(bimagem);
			 }else if(id.equals("image2")) {
				 this.relatorio.setImg2(bimagem);
			 }else if(id.equals("image3")) {
				 this.relatorio.setImg3(bimagem);
			 }else if(id.equals("image4")) {
				 this.relatorio.setImg4(bimagem);
			 }else {
				 this.relatorio.setDocumento(bimagem);
			 }
		}catch(Exception ex){
			 ex.printStackTrace();
		}
	}

	public boolean isExibirFotos() {
		if(this.relatorio != null) {
			if(this.relatorio.getImg1() != null) {
				this.exibirFotos = true;
			}
			
			if(this.relatorio.getImg2() != null) {
				this.exibirFotos = true;
			}
			
			if(this.relatorio.getImg2() != null) {
				this.exibirFotos = true;
			}
			
			if(this.relatorio.getImg2() != null) {
				this.exibirFotos = true;
			}
			
		}
		return exibirFotos;
	}
	
}
