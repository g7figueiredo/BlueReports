package br.com.bluereports.relatorio;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RelatorioDAOHibernate implements RelatorioDAO {
	
	private Session Session;
	
	public Session getSession() {
		return Session;
	}

	public void setSession(Session session) {
		Session = session;
	}

	@Override
	public void salvar(Relatorio relatorio) {
		this.Session.save(relatorio);
	}

	@Override
	public List<Relatorio> listaRelatorio() {
		Criteria criteria = this.Session.createCriteria(Relatorio.class);
		criteria.add(Restrictions.eq("statusCad", "A"));
		
		@SuppressWarnings("unchecked")
		List<Relatorio> results = criteria.list();
		
		return results;
	}

	@Override
	public Relatorio buscarPorId(int id) {
		Criteria criteria = this.Session.createCriteria(Relatorio.class);
		criteria.add(Restrictions.eq("idRelatorio", id));
		criteria.add(Restrictions.eq("statusCad", "A"));
		
		return (Relatorio) criteria.uniqueResult();
	}
	

}
