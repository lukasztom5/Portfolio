package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.Urzadzenie;

public class UrzadzenieDaoImpl implements UrzadzenieDao{
	private static final Log log = LogFactory.getLog(UrzadzenieDaoImpl.class);

	private Session session;
	private Transaction tx;
	public void save(Urzadzenie urzadzenie) {
		log.debug("persisting Urzadzenie instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(urzadzenie);
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
	public Urzadzenie findById(int id) {
		log.debug("getting URZADZENIE instance with IDURZADZENIE: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Urzadzenie result = (Urzadzenie) session.get(Urzadzenie.class, id);
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
	public boolean UrzadzenieExists(Urzadzenie urzadzenie) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from URZADZENIE where IDURZADZENIE='"
							+ urzadzenie.getIdurzadzenie()+ "'");
			Urzadzenie c = (Urzadzenie) query.uniqueResult();
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

		public Integer NewIdUrzadz() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			Integer result = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session
						.createSQLQuery("select max(IDURZADZENIE) FROM URZADZENIE");
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
	
	
	@SuppressWarnings("unchecked")
	public List<Urzadzenie> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Urzadzenie> List = new ArrayList<Urzadzenie>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from URZADZENIE");
			q.addEntity(Urzadzenie.class);
			List = q.list();
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
	public void removeById(int idurzadz) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from URZADZENIE where IDURZADZENIE=" + idurzadz);
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
	@Override
	public Urzadzenie findBynazwa(String urzadzenie) {
		session = HibernateUtil.getSessionFactory().openSession();
		Urzadzenie sc = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Urzadzenie where idurzadzenie in (select id from URZADZENIE_DANE where nazwa='"
							+ urzadzenie
							+ "')");
			sc = (Urzadzenie) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return sc;
	}
	
}
