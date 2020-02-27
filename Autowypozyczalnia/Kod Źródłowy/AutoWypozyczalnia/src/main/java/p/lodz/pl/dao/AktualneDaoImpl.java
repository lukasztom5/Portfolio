package p.lodz.pl.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.AktualneWypozyczenie;

public class AktualneDaoImpl implements AktualneDao{

	private static final Log log = LogFactory.getLog(AktualneDaoImpl.class);

	private Session session;
	private Transaction tx;

	public void save(AktualneWypozyczenie aktualne){
		log.debug("persisting aktualne_wypozyczenie instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(aktualne);
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

	public AktualneWypozyczenie update(AktualneWypozyczenie aktualne){
		log.debug("merging aktualne_wypozyczenie");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			AktualneWypozyczenie result= (AktualneWypozyczenie) session.merge(aktualne);
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

	public void remove(AktualneWypozyczenie aktualne){
		log.debug("removing AktualneWypozyczenie");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(aktualne);
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
	
	public AktualneWypozyczenie findById(int id) {
		log.debug("getting aktualne_wypozyczenie instance with id: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			AktualneWypozyczenie result = (AktualneWypozyczenie) session.get(AktualneWypozyczenie.class, id);
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

	
	public void removeById(int idaktualne_wypozyczenie) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createSQLQuery("delete from aktualne_wypozyczenie where idaktualne_wypozyczenie=" + idaktualne_wypozyczenie);
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
	public List<AktualneWypozyczenie> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<AktualneWypozyczenie>List = new ArrayList<AktualneWypozyczenie>();
		try {
			tx = session.getTransaction();
			tx.begin();
			List = session.createQuery(
					"from aktualne_wypozyczenie").list();
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
	public List<AktualneWypozyczenie> findAutaByKlient(int klientid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<AktualneWypozyczenie> AutaList = new ArrayList<AktualneWypozyczenie>();
		try {
			tx = session.getTransaction();
			tx.begin();
			 AutaList = session.createQuery(
					"from AktualneWypozyczenie where klientid="+klientid).list();
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
	public List<AktualneWypozyczenie> findKlientByIdAuta(int idauta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<AktualneWypozyczenie> KlientList = new ArrayList<AktualneWypozyczenie>();
		try {
			tx = session.getTransaction();
			tx.begin();
			KlientList = session.createQuery(
					"from AktualneWypozyczenie where autoid=" + idauta).list();
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
	public boolean AktualneExists(AktualneWypozyczenie aw) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from aktualne_wypozyczenie where idaktualneWypozyczenie='"
							+ aw.getIdaktualneWypozyczenie() + "'");
			AktualneWypozyczenie c = (AktualneWypozyczenie) query.uniqueResult();
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
	public Integer NewIdAktualne() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(idaktualne_wypozyczenie) from aktualne_wypozyczenie");
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
	public AktualneWypozyczenie FindByMaxId() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		AktualneWypozyczenie result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select* from aktualne_wypozyczenie where idaktualne_wypozyczenie=(select max(idaktualne_wypozyczenie) from aktualne_wypozyczenie)");
			result = (AktualneWypozyczenie) query.uniqueResult();
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
