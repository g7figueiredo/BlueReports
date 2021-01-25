package br.com.bluereports.relatorio;

import java.util.List;

public interface RelatorioDAO {

	public void salvar(Relatorio relatorio);
	
	public List<Relatorio> listaRelatorio();
	
	public Relatorio buscarPorId(int id);
	
}
