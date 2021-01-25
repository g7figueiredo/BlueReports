package br.com.bluereports.usuario;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsuarioDAOHibernate implements UsuarioDAO {
	
	private Session Session;
	
	public Session getSession() {
		return Session;
	}

	public void setSession(Session session) {
		Session = session;
	}

	@Override
	public void salvar(Usuario usuario) {
		this.Session.save(usuario);
	}

	@Override
	public List<Usuario> listaUsuario() {
		Criteria criteria = this.Session.createCriteria(Usuario.class);
//		criteria.add(Restrictions.eq("statusCad", "A"));
		
		@SuppressWarnings("unchecked")
		List<Usuario> results = criteria.list();
		
		return results;
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		Criteria criteria = this.Session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", email));
//		criteria.add(Restrictions.eq("statusCad", "A"));
		
		return (Usuario) criteria.uniqueResult();
	}
	
	@Override
	public void atualizarSenha(Usuario usuario) {
		this.Session.update(usuario);
	}
}
