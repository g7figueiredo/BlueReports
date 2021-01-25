package br.com.bluereports.dbUtil;
import org.hibernate.Session;


public class Conecta {

	public static void main(String[] args) {
		Session session = null;
		try{
			session = HibernateUtil.getSession().openSession();
			System.out.println("OK, Conectou!");
		}catch (Exception e) {
			System.out.println("Erro na conex�o: ");
			e.printStackTrace();
		}finally{
			session.close();
			System.out.println("Terminado, conex�o fechada!");
		}

	}

}
