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
import encje.*;

public class KoszykDaoImpl implements KoszykDao{
	private static final Log log = LogFactory.getLog(KoszykDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public boolean KoszykExists(Koszyk koszyk) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from KOSZYK where IDZAKUP='"
							+ koszyk.getIdkoszyk()+ "'");
			Koszyk c = (Koszyk) query.uniqueResult();
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

	@Override
	public void save(Koszyk koszyk) {
		log.debug("persisting KOSZYK instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(koszyk);
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
	public Integer NewIdKoszyk() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(IDZAKUP) FROM KOSZYK");
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
	public void removeById(int idkoszyk) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from KOSZYK where IDZAKUP=" + idkoszyk);
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
	@Override
	public List<Koszyk> findByIdkl(int idklient) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Koszyk> lista= new ArrayList<Koszyk>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from KOSZYK where IDKLIENT='"+ idklient+"'");
			q.addEntity(Koszyk.class);
			lista = q.list();
			t.commit();
		}catch(Exception e){
			if(t!=null)
				t.rollback();
		}finally {
			sess.close();
		}
		return lista;
	}

	@Override
	public Koszyk findById(int id) {
		log.debug("getting KOSZYK instance with id: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Koszyk result = (Koszyk) session.get(Koszyk.class, id);
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


}
