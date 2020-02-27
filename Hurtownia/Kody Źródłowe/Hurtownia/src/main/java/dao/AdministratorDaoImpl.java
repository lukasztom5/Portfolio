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
import encje.Administrator;
import dao.AdministratorDaoImpl;

public class AdministratorDaoImpl implements AdministratorDao{
	private static final Log log = LogFactory.getLog(AdministratorDaoImpl.class);

	private Session session;
	private Transaction tx;
	public Administrator findById(int id) {
		log.debug("getting ADMINISTRATOR instance with id: " + id);
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
	public Administrator findByIdadmin(int id) {
			session = HibernateUtil.getSessionFactory().openSession();
			Administrator result = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session
						.createQuery("from ADMINISTRATOR where IDADMINISTRATOR='"
								+ id + "'");
				result = (Administrator) query.uniqueResult();
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
	@SuppressWarnings("unchecked")
	public List<Administrator> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Administrator> List = new ArrayList<Administrator>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from ADMINISTRATOR");
			q.addEntity(Administrator.class);
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
	public Administrator findByIdadminP(Administrator a) {
		session = HibernateUtil.getSessionFactory().openSession();
		Administrator result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from ADMINISTRATOR where IDADMINISTRATOR='"
							+ a + "'");
			result = (Administrator) query.uniqueResult();
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
	@Override
	public Administrator findbylogin(String login) {
		session = HibernateUtil.getSessionFactory().openSession();
		Administrator sc = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Administrator where login='"
							+ login
							+ "'");
			sc = (Administrator) query.uniqueResult();
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
