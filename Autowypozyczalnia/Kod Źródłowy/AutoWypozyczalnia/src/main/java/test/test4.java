package test;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.Segment;

public class test4 extends SQLException{

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
	Session session=HibernateUtil.getSessionFactory().openSession();
	Query query = session.getNamedQuery("Segment.findAll");
	@SuppressWarnings("unchecked")
	List<Segment> r=query.list();
	for(Segment s:r)
		System.out.print(s.getCenaZaDobe()+"\n");
	

}

}
