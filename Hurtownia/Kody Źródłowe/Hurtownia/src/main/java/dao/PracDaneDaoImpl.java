package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.PracDane;

public class PracDaneDaoImpl implements PracDaneDao{
	private static final Log log = LogFactory.getLog(PracownikDaoImpl.class);

	private Session session;
	private Transaction tx;

	@SuppressWarnings("unchecked")
	public List<PracDane> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<PracDane> List = new ArrayList<PracDane>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from PRAC_DANE");
			q.addEntity(PracDane.class);
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
	public PracDane findByIdprac(int idprac) {
		
		log.debug("getting PRAC_DANE instance with id: " + idprac);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			PracDane result = (PracDane) session.get(PracDane.class, idprac);
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
