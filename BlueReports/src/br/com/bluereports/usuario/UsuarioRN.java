package br.com.bluereports.usuario;

import java.util.List;

import br.com.bluereports.dbUtil.DAOFactory;

public class UsuarioRN {
	
	private UsuarioDAO usuarioDao;
	
	public UsuarioRN() {
		this.usuarioDao = DAOFactory.criarUsuarioDAO();
	}

	public void salvar(Usuario usuario) {
		this.usuarioDao.salvar(usuario);
		
	}
	
	public List<Usuario> listaUsuario(){
		return this.usuarioDao.listaUsuario();
	}
	
	public Usuario buscarPorEmail(String email){
		return this.usuarioDao.buscarPorEmail(email);
	}
	
	public void atualizarSenha(Usuario usuario) {
		this.usuarioDao.atualizarSenha(usuario);
	}
	
}
