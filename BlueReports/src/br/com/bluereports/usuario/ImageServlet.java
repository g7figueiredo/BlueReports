package br.com.bluereports.usuario;


import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID = -4635239628819022096L;
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Retirando a barra / da URL
        // No caso, se o usu�rio digitasse www.projeto.com/images/1
        // o request.getPathInfo() iria retornar: /1
        String cpf = request.getPathInfo().substring(1);
 
        //Recuperando um objeto imagem do banco de dados atrav�s do ID passado na URL digitada
        byte[] image = null;
		try {
			//image = new UsuarioDao().buscarImagemPorCpf(cpf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        OutputStream out = response.getOutputStream();
        out.write(image); // Passando o array de bytes
        out.close();
 
        // Aqui a imagem estar� renderizada e dispon�vel em,
        // por exemplo: www.projeto.com/images/1
    }

}
