package p.lodz.pl.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.Administrator;

public class AdministratorDaoImpl implements AdministratorDao{
	private static final Log log = LogFactory.getLog(AdministratorDaoImpl.class);

	private Session session;
	private Transaction tx;
	public Administrator findById(int id) {
		log.debug("getting Administrator instance with id: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Administrator result = (Administrator) session.get(Administrator.class, id);
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
	public boolean AdminExists(Administrator administrator) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Administrator where idadministrator='"
							+ administrator.getIdadministrator()+ "'");
			Administrator a = (Administrator) query.uniqueResult();
			tx.commit();
			if (a != null)
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

}
