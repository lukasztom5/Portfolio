package p.lodz.pl.dao;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.Auta;

public class AutoDaoImpl implements AutaDao{

	
	private static final Log log = LogFactory.getLog(AutoDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public void save(Auta auto){
		log.debug("persisting Auta");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(auto);
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
	public void remove(Auta auto){
		log.debug("removing Auta");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(auto);
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
	public Auta update(Auta auto){
		log.debug("merging Auta");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Auta result = (Auta) session.merge(auto);
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
	public Auta findById(int id) {
		log.debug("getting Auta instance with id: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Auta result = (Auta) session.get(Auta.class, id);
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
	public void removeById(int idauta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createSQLQuery("delete FROM Auta where idauta=" + idauta);
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
	public List<Auta> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Auta>List = new ArrayList<Auta>();
		try {
			tx = session.getTransaction();
			tx.begin();
			List = session.createQuery(
					"FROM Auta").list();
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
	public Integer NewIdAuto() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(idauta) from Auta");
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

	public boolean AutoExists(Auta auto) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Auta where idauta='"
							+ auto.getIdauta() + "'");
			Auta c = (Auta) query.uniqueResult();
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
	public Auta findAutaByModelMarka(String marka,String model) {
		session = HibernateUtil.getSessionFactory().openSession();
		Auta a = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Auta where marka='"+ marka
							+ "'"+ "and model='"+model+ "'");
			a = (Auta) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return a;
}	@SuppressWarnings("unchecked")
	public List<Auta> findWolneAuta() {
	
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			List<Auta> lista = new ArrayList<Auta>();
			try {
				tx = session.getTransaction();
				tx.begin();
				SQLQuery q = session.createSQLQuery(
						"select * from Auta where idauta not in (select autoid from aktualne_wypozyczenie)");
				
				q.addEntity(Auta.class);
				lista = q.list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
			} finally {
				session.close();
			}
			return lista;
		}

}
