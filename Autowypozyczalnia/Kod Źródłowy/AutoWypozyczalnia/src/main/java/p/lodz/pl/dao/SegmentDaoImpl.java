package p.lodz.pl.dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.Segment;

public class SegmentDaoImpl implements SegmentDao{
	public Segment findSegment(String rodzaj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Segment s=null;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Segment where rodzaj='"+ rodzaj+ "'");
			s = (Segment) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return s;
	}
	public Segment findByCena(int CenaZaDobe) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Segment s=null;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Segment where cena_za_dobe="+CenaZaDobe);
			s = (Segment) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	public List<Segment> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Segment>List = new ArrayList<Segment>();
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
