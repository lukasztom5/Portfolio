package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.ModelDane;

public class ModelDaneDaoImpl implements ModelDaneDao{
	private static final Log log = LogFactory.getLog(ModelDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public ModelDane findByIdmodel(int idmodel) {
		log.debug("getting MODEL_DANE instance with ID: " + idmodel);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			ModelDane result = (ModelDane) session.get(ModelDane.class, idmodel);
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
