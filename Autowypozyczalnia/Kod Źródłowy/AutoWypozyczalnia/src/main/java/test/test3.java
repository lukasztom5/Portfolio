package test;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import p.lodz.pl.encje.Klient;
import Hibernate.HibernateUtil;

public class test3 extends SQLException{

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Query query = session.getNamedQuery("kfindAll");
		@SuppressWarnings("unchecked")
		List<Klient> r=query.list();
		for(Klient k:r)
			System.out.print(k.getIdklient()+" "+k.getLogin()+" " +k.getHaslo()+" "+k.getTelefon()+"\n");
		

	}

}
