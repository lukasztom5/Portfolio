package test;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import p.lodz.pl.encje.Administrator;
import Hibernate.HibernateUtil;

public class test extends SQLException{

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Query q=session.getNamedQuery("findById").setString("idad", "1");
		@SuppressWarnings("unchecked")
		List<Administrator> r=q.list();
		System.out.println(r.get(0).getIdadministrator());
		System.out.println(r.get(0).getImie());
		System.out.println(r.get(0).getNazwisko());
		System.out.println(r.get(0).getLogin());
		System.out.println(r.get(0).getHaslo());
		
	}

}
