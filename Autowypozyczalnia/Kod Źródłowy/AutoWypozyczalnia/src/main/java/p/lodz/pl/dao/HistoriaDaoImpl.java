package p.lodz.pl.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.HistoriaWypozyczenia;

public class HistoriaDaoImpl implements HistoriaDao{

	private static final Log log = LogFactory.getLog(HistoriaDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public void save(HistoriaWypozyczenia historia){
		log.debug("persisting historia_wypozyczenia instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(historia);
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
	public HistoriaWypozyczenia update(HistoriaWypozyczenia historia){
		log.debug("merging historia_wypozyczenia");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			HistoriaWypozyczenia result= (HistoriaWypozyczenia) session.merge(historia);
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
	public void remove(HistoriaWypozyczenia historia){
		log.debug("removing historia_wypozyczenia");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(historia);
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
	public HistoriaWypozyczenia findById(int id) {
		log.debug("getting HistoriaWypozyczenia instance with id: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			HistoriaWypozyczenia result = (HistoriaWypozyczenia) session.get(HistoriaWypozyczenia.class, id);
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
	public void removeById(int idhistoria_wypozyczenia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createSQLQuery("delete from historia_wypozyczenia where idhistoria_wypozyczenia=" + idhistoria_wypozyczenia);
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
	public boolean HistoriaExists(HistoriaWypozyczenia hw) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from historia_wypozyczenia where idhistoria_wypozyczenia='"
							+ hw.getIdhistoriaWypozyczenia() + "'");
			HistoriaWypozyczenia c = (HistoriaWypozyczenia) query.uniqueResult();
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
	public List<HistoriaWypozyczenia> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<HistoriaWypozyczenia>List = new ArrayList<HistoriaWypozyczenia>();
		try {
			tx = session.getTransaction();
			tx.begin();
			List = session.createQuery(
					"from historia_wypozyczenia").list();
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
	public List<HistoriaWypozyczenia> findAutaByKlient(int klientid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<HistoriaWypozyczenia> AutaList = new ArrayList<HistoriaWypozyczenia>();
		try {
			tx = session.getTransaction();
			tx.begin();
			 AutaList = session.createQuery(
					"from HistoriaWypozyczenia where klientid="+klientid).list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return  AutaList;
	}

	@SuppressWarnings("unchecked")
	public List<HistoriaWypozyczenia> findKlientByAuta(int autaid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<HistoriaWypozyczenia> KlientList = new ArrayList<HistoriaWypozyczenia>();
		try {
			tx = session.getTransaction();
			tx.begin();
			KlientList = session.createQuery(
					"from HistoriaWypozyczenia  where autoid=" + autaid).list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return  KlientList;
	}
	public Integer NewIdHistoria() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(idhistoria_wypozyczenia) from historia_wypozyczenia");
			Integer result2 = (Integer ) query.uniqueResult();
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
	public HistoriaWypozyczenia FindByMaxId() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		HistoriaWypozyczenia result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select* from aktualne_wypozyczenie where idaktualne_wypozyczenie=(select max(idaktualne_wypozyczenie) from aktualne_wypozyczenie)");
			result = (HistoriaWypozyczenia) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
}
