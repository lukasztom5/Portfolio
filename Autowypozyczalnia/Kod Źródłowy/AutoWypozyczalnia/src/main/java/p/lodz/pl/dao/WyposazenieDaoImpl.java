package p.lodz.pl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.Segment;
import p.lodz.pl.encje.Wyposazenie;

public class WyposazenieDaoImpl implements WyposazenieDao{
	@SuppressWarnings("unchecked")
	public List<Wyposazenie> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Wyposazenie>List = new ArrayList<Wyposazenie>();
		try {
			tx = session.getTransaction();
			tx.begin();
			List = session.createQuery(
					"from Wyposazenie").list();
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
	public Wyposazenie findByCena(int cenaDzien) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Wyposazenie w=null;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Wyposazenie where cena_dzien="+cenaDzien);
			w = (Wyposazenie) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return w;
	}
	public Wyposazenie findById(int idwyposazenie) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Wyposazenie w=null;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Wyposazenie where idwyposazenie="+idwyposazenie);
			w = (Wyposazenie) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return w;
	}
	public Wyposazenie findByNazwa(String dodatek) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Wyposazenie w=null;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Wyposazenie where dodatek="+dodatek);
			w = (Wyposazenie) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return w;
	}
}
