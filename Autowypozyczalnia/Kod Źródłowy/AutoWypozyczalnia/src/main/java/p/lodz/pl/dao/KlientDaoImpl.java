package p.lodz.pl.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.Klient;

public class KlientDaoImpl implements KlientDao{
	private static final Log log = LogFactory.getLog(KlientDaoImpl.class);

	private Session session;
	private Transaction tx;

	public void save(Klient klient) {
		log.debug("persisting Klient instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(klient);
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
	public void remove(Klient klient){
		log.debug("removing Klient instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(klient);
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
	public Klient update(Klient klient){
		log.debug("merging Klient instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Klient result = (Klient) session.merge(klient);
			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (Exception e) {
			log.error("merge failed", e);
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	public Klient findById(int id) {
		log.debug("getting Klient instance with id: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Klient result = (Klient) session.get(Klient.class, id);
			tx.commit();
			log.debug("get successful");
			return result;
		} catch (RuntimeException e) {
			log.error("get failed", e);
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	public boolean KlientExists(Klient klient) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Klient where idklient='"
							+ klient.getIdklient()+ "'");
			Klient c = (Klient) query.uniqueResult();
			tx.commit();
			if (c != null)
				result = true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
	public Integer NewIdKlient() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(idklient) FROM Klient");
			Integer result2 = (Integer) query.uniqueResult();
			if (result2 == null) {
				result = 0;
			} else
				result = result2.intValue();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result + 1;
	}
	@Override
	public void removeById(int idklient) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from Klient where idklient=" + idklient);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Klient> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Klient> List = new ArrayList<Klient>();
		try {
			tx = session.getTransaction();
			tx.begin();
			List = session.createQuery("FROM Klient").list();
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
