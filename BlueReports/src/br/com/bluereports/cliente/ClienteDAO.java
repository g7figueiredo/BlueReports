package br.com.bluereports.cliente;

import java.util.List;

public interface ClienteDAO {

	public void salvar(Cliente cliente);
	
	public List<Cliente> listaCliente();
	
	public Cliente buscarPorId(int id);
	
}
