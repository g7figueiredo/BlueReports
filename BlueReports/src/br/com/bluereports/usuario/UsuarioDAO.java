package br.com.bluereports.usuario;

import java.util.List;

public interface UsuarioDAO {

	public void salvar(Usuario usuario);
	
	public List<Usuario> listaUsuario();
	
	public Usuario buscarPorEmail(String email);
	
	public void atualizarSenha(Usuario usuario);
	
}
