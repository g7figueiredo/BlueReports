package br.com.bluereports.cliente;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ClienteDAOHibernate implements ClienteDAO {
	
	private Session Session;
	
	public Session getSession() {
		return Session;
	}

	public void setSession(Session session) {
		Session = session;
	}

	@Override
	public void salvar(Cliente cliente) {
		this.Session.save(cliente);
	}

	@Override
	public List<Cliente> listaCliente() {
		Criteria criteria = this.Session.createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("statusCad", "A"));
		
		@SuppressWarnings("unchecked")
		List<Cliente> results = criteria.list();
		
		return results;
	}

	@Override
	public Cliente buscarPorId(int id) {
		Criteria criteria = this.Session.createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("idCliente", id));
		criteria.add(Restrictions.eq("statusCad", "A"));
		
		return (Cliente) criteria.uniqueResult();
	}
	

}
