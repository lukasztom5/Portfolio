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
import dao.RozliczenieDao;
import encje.*;

public class RozliczenieDaoImpl implements RozliczenieDao{
	private static final Log log = LogFactory.getLog(RozliczenieDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public void save(Rozliczenie roz){
		log.debug("persisting ROZLICZENIE");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(roz);
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
	@Override
	public Rozliczenie update(Rozliczenie roz) {
		log.debug("merging ROZLICZENIE");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Rozliczenie result = (Rozliczenie) session.merge(roz);
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
	@Override
	public Rozliczenie findById(int id) {
		log.debug("getting ROZLICZENIE instance with id: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Rozliczenie result = (Rozliczenie) session.get(Rozliczenie.class, id);
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
	@Override
	public Integer NewIdRozliczenie() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(IDROZLICZENIE) FROM ROZLICZENIE");
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
	public boolean RozliczenieExists(Rozliczenie roz) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from ROZLICZENIE where IDROZLICZENIE='"
							+ roz.getIDROZLICZENIE()+ "'");
			Rozliczenie c = (Rozliczenie) query.uniqueResult();
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
	@SuppressWarnings("unchecked")
	public List<Rozliczenie> findByPracownika(int idprac) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rozliczenie> List = new ArrayList<Rozliczenie>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from ROZLICZENIE where IDPRACOWNIK='"+idprac+ "'");
			q.addEntity(Rozliczenie.class);
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
	@SuppressWarnings("unchecked")
	public List<Rozliczenie> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Rozliczenie> List = new ArrayList<Rozliczenie>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from ROZLICZENIE");
			q.addEntity(Rozliczenie.class);
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
	public void removeByIdPrac(int idprac) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from ROZLICZENIE where IDPRACOWNIK=" + idprac);
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
}
