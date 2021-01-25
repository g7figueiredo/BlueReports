package br.com.bluereports.cliente;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bluereports.util.Util;

@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codString) {
		if(codString != null && codString.trim().length() > 0){
			if(Util.containsOnlyNumbers(codString)) {
				int codigo = Integer.valueOf(codString);
				ClienteRN clienteRN = new ClienteRN();
				
				try {
					return clienteRN.buscarPorId(codigo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object clienteObj) {
		if(clienteObj != null){
			Cliente cliente = (Cliente) clienteObj;
			
			return String.valueOf(cliente.getIdCliente());
		}
		
		return null;
	}

}
