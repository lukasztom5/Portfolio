package test;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import p.lodz.pl.encje.Auta;
import Hibernate.HibernateUtil;

public class test2 extends SQLException{

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Query query = session.getNamedQuery("findAll");
		@SuppressWarnings("unchecked")
		List<Auta> r=query.list();
		for(Auta a:r)
			System.out.print(a.getIdauta());
		

	}

}
