package br.com.bluereports.util;

import java.util.Iterator;
import java.util.regex.Pattern;

import org.json.JSONObject;


public class ProcessarJson {
	
	public static JSONObject processarStringPontoVirgula(String string) {
		String valores[] = string.split(Pattern.quote(";"));
		JSONObject retorno = new JSONObject();
		for(int i = 0; i < valores.length; i++) {
			retorno.put("resposta " + i, valores[i]);
		}
		
		return retorno;
	}
	
	public static String processarJsonPontoVirgula(JSONObject jso) {
		String retorno = "";
		Iterator<String> keys = jso.keys();
		while(keys.hasNext()) {
		   String key = keys.next();
		   if(retorno.length() == 0) {
			   retorno = jso.getString(key);
		   }else {
			   retorno += "; " + jso.getString(key);
		   }
		}
		
		return retorno;
	}

}
