package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.AdminDane;

public class AdminDaneDaoImpl implements AdminDaneDao{
	private static final Log log = LogFactory.getLog(KlientDaoImpl.class);

	private Session session;
	private Transaction tx;
	
public AdminDane findByIdAdmin(int idadmin) {
		
		log.debug("getting ADMIN_DANE instance with id: " + idadmin);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			AdminDane result = (AdminDane) session.get(AdminDane.class, idadmin);
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
