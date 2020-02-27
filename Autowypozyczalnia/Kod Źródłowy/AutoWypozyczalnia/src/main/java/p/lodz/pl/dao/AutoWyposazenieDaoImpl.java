package p.lodz.pl.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.AutoWyposazenie;

public class AutoWyposazenieDaoImpl implements AutoWyposazenieDao{
	private static final Log log = LogFactory.getLog(AutoWyposazenieDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public void remove(AutoWyposazenie aw){
		log.debug("removing auto_wyposazenie");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(aw);
			tx.commit();
			log.debug("remove successful");
		} catch (Exception e) {
			log.error("remove failed", e);
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	@Override
	public void save(AutoWyposazenie aw){
		log.debug("persisting auto_wyposazenie");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(aw);
			tx.commit();
			log.debug("persist successful");
		} catch (Exception e) {
			log.error("persist failed", e);
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<AutoWyposazenie> findWypByIdAuta(int idauta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<AutoWyposazenie> WypList = new ArrayList<AutoWyposazenie>();
		try {
			tx = session.getTransaction();
			tx.begin();
			WypList = session.createQuery(
					"from auto_wyposazenie where idauta=" + idauta).list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return WypList;
	}
	@SuppressWarnings("unchecked")
	public List<AutoWyposazenie> findAutoByIdWyp(int idwyposazenie) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<AutoWyposazenie> AutoList = new ArrayList<AutoWyposazenie>();
		try {
			tx = session.getTransaction();
			tx.begin();
			AutoList = session.createQuery(
					"from auto_wyposazenie where idwyposazenie=" + idwyposazenie).list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return AutoList;
	}
	@SuppressWarnings("unchecked")
	public List<AutoWyposazenie> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<AutoWyposazenie> List = new ArrayList<AutoWyposazenie>();
		try {
			tx = session.getTransaction();
			tx.begin();
			List = session.createQuery(
					"from auto_wyposazenie").list();
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
	@Override
	public List<AutoWyposazenie> findAutoByWyp(int idwyposazenie) {
		// TODO Auto-generated method stub
		return null;
	}
}
