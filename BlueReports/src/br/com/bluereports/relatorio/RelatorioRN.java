package br.com.bluereports.relatorio;

import java.util.List;

import br.com.bluereports.dbUtil.DAOFactory;

public class RelatorioRN {
	
	private RelatorioDAO relatorioDao;
	
	public RelatorioRN() {
		this.relatorioDao = DAOFactory.criarRelatorioDAO();
	}

	public void salvar(Relatorio relatorio) {
		this.relatorioDao.salvar(relatorio);
		
	}
	
	public List<Relatorio> listaRelatorio(){
		return this.relatorioDao.listaRelatorio();
	}
	
	public Relatorio buscarPorId(int id){
		return this.relatorioDao.buscarPorId(id);
	}
	
}
