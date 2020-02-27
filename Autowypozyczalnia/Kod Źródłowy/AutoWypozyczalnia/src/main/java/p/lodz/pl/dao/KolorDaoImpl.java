package p.lodz.pl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.Kolor;

public class KolorDaoImpl implements KolorDao{
	@SuppressWarnings("unchecked")
	public List<Kolor> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Kolor> List = new ArrayList<Kolor>();
		try {
			tx = session.getTransaction();
			tx.begin();
			List = session.createQuery(
					"from kolor").list();
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
