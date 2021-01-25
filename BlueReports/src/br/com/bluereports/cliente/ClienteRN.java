package br.com.bluereports.cliente;

import java.util.List;

import br.com.bluereports.dbUtil.DAOFactory;

public class ClienteRN {
	
	private ClienteDAO clienteDao;
	
	public ClienteRN() {
		this.clienteDao = DAOFactory.criarClienteDAO();
	}

	public void salvar(Cliente cliente) {
		this.clienteDao.salvar(cliente);
		
	}
	
	public List<Cliente> listaCliente(){
		return this.clienteDao.listaCliente();
	}
	
	public Cliente buscarPorId(int id){
		return this.clienteDao.buscarPorId(id);
	}
	
}
