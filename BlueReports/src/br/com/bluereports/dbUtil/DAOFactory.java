package br.com.bluereports.dbUtil;

import br.com.bluereports.cliente.ClienteDAO;
import br.com.bluereports.cliente.ClienteDAOHibernate;
import br.com.bluereports.relatorio.RelatorioDAO;
import br.com.bluereports.relatorio.RelatorioDAOHibernate;
import br.com.bluereports.usuario.UsuarioDAO;
import br.com.bluereports.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static ClienteDAO criarClienteDAO() {
		ClienteDAOHibernate clienteDAOHibernate = new ClienteDAOHibernate();
		clienteDAOHibernate.setSession(HibernateUtil.getSession().getCurrentSession());
		
		return clienteDAOHibernate;
	}

	public static RelatorioDAO criarRelatorioDAO() {
		RelatorioDAOHibernate relatorioDAOHibernate = new RelatorioDAOHibernate();
		relatorioDAOHibernate.setSession(HibernateUtil.getSession().getCurrentSession());
		
		return relatorioDAOHibernate;
	}

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAOHibernate = new UsuarioDAOHibernate();
		usuarioDAOHibernate.setSession(HibernateUtil.getSession().getCurrentSession());
		
		return usuarioDAOHibernate;
	}

}
