package br.com.bluereports.usuario;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import br.com.bluereports.mail.EnviarEmail;

@ManagedBean(name="recoverPass")
@RequestScoped
public class RecoverPassBean {
	
	private String email;
	
	private String[] chars = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", 
			"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", 
			"6", "7", "8", "9", "0", "!", "@", "#", "$", "%", "&", "*"};
	
	public String recoverPass(){
		try{
			Usuario usuario = new UsuarioRN().buscarPorEmail(email);
			
			if(usuario != null){
				String newPass = "";
				
				for(int i = 0; i < 10; i++){
					newPass += chars[(int) (Math.random() * chars.length)];
				}
				
				usuario.setPass(getMD5(newPass));
				new UsuarioRN().atualizarSenha(usuario);
				
				new EnviarEmail().Enviar(setProperties(), usuario.getEmail(), newPass);
				
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Email enviado com sucesso!"));
				context.getExternalContext().getFlash().setKeepMessages(true);  //AQUI ELE MANTEM A MENSAGEM 
				
				return "index";
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Usuário não encontrado, solicite nova senha ao seu superior!"));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	private Properties setProperties(){
		Properties props = new Properties();
		
		props.setProperty("pro.smtp", "smtp.hostinger.com.br");
		props.setProperty("pro.porta", "587");
		props.setProperty("pro.remetente", "administrativo@bluetherm.com.br");
		props.setProperty("pro.nome", "BlueReports");
		props.setProperty("pro.pass", "fla8264917$*");
		props.setProperty("pro.assunto", "Recuperação de Senha de Acesso");

		return props;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
