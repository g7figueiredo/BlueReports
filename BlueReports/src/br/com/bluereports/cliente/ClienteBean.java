package br.com.bluereports.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="clienteBean")
@ViewScoped
public class ClienteBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2723730776199497361L;
	private Cliente cliente = new Cliente();
	private int tipoPessoa = 0;
	private boolean renderedCPF = true;
	private boolean renderedCNPJ = false;
	private String descricaoLabel = "CPF";
	
	private String numCpf = "";
	private String numCnpj = "";
	
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private Cliente clienteSelecionado = new Cliente();
	
	public ClienteBean() {
		listarTodos();
	}
	
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public String getNumCpf() {
		return numCpf;
	}


	public void setNumCpf(String numCpf) {
		this.numCpf = numCpf;
	}


	public String getNumCnpj() {
		return numCnpj;
	}


	public void setNumCnpj(String numCnpj) {
		this.numCnpj = numCnpj;
	}


	public String getDescricaoLabel() {
		return descricaoLabel;
	}

	public void setDescricaoLabel(String descricaoLabel) {
		this.descricaoLabel = descricaoLabel;
	}

	public boolean isRenderedCPF() {
		return renderedCPF;
	}

	public void setRenderedCPF(boolean renderedCPF) {
		this.renderedCPF = renderedCPF;
	}

	public boolean isRenderedCNPJ() {
		return renderedCNPJ;
	}

	public void setRenderedCNPJ(boolean renderedCNPJ) {
		this.renderedCNPJ = renderedCNPJ;
	}

	public int getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(int tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private void limpar(){
		this.cliente = new Cliente();

	}
	
	/*
	 * MÉTODOS DAO ----------------------------------------------------------------------------------------------------------------
	 */
	
	public void renderizarPainel(){
		if(getTipoPessoa()==0) {
			this.renderedCPF = true;
			this.descricaoLabel = "CPF";
			this.renderedCNPJ = false;
		}else {
			this.renderedCPF = false;
			this.renderedCNPJ = true;
			this.descricaoLabel = "CNPJ";
		}
	}
	
	
	public void listarTodos(){
		ClienteRN clienteRN = new ClienteRN();
		this.listaCliente = clienteRN.listaCliente();
	}
	
	
	public String salvar(){
		ClienteRN clienteRN = new ClienteRN();
		cliente.setStatusCad("A");
		if(getTipoPessoa() == 0) {
			this.cliente.setNumCpfCnpj(this.numCpf);
		}else {
			this.cliente.setNumCpfCnpj(this.numCnpj);
		}
		
		clienteRN.salvar(cliente);

		FacesMessage message = new FacesMessage("Cliente cadastrado com sucesso!");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
		
		limpar();
		return "";
	}

	


}
