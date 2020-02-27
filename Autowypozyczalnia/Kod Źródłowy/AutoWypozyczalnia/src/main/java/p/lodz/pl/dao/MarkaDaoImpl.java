package p.lodz.pl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.Marka;


public class MarkaDaoImpl implements MarkaDao{
	@SuppressWarnings("unchecked")
	public List<Marka> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Marka>List = new ArrayList<Marka>();
		try {
			tx = session.getTransaction();
			tx.begin();
			List = session.createQuery(
					"from wyposazenie").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return List;
	}

}
