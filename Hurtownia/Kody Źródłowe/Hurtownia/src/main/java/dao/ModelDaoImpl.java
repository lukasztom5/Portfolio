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
import encje.Model;

public class ModelDaoImpl implements ModelDao{
	private static final Log log = LogFactory.getLog(ModelDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public boolean ModelExists(Model model) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from MODEL where IDMODEL='"
							+ model.getIDMODEL()+ "'");
			Model c = (Model) query.uniqueResult();
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
	public void save(Model model) {
		log.debug("persisting Model instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(model);
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
	public Integer NewIdModel() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(IDMODEL) FROM MODEL");
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
	public Model findById(int id) {
		log.debug("getting MODEL instance with IDMODEL: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Model result = (Model) session.get(Model.class, id);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Model> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Model> List = new ArrayList<Model>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from MODEL");
			q.addEntity(Model.class);
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
	public void removeById(int idmodel) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from MODEL where IDMODEL=" + idmodel);
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

	@Override
	public void removeByIdUrzad(int idurzadzenie) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from MODEL where IDURZADZENIE=" + idurzadzenie);
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
	public List<Model> findByIdurzadz(int idurzadzenie) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Model> lista= new ArrayList<Model>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from MODEL where IDURZADZENIE='"+ idurzadzenie+"'");
			q.addEntity(Model.class);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Model> findByurzadznazwa(String nazwa) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Model> lista= new ArrayList<Model>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from MODEL where IDURZADZENIE=(select IDURZADZENIE from KATEGORIA where IDKATEGORIA in(select id from KAT_WIDOK where nazwa='"+ nazwa+"'))");
			q.addEntity(Model.class);
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Model> findByurzadznazwa1(String nazwa) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Model> lista= new ArrayList<Model>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from Model where IDURZADZENIE=(select IDURZADZENIE from MODEL where IDMODEL in(select id from MODEL_DANE where model='"+ nazwa+"'))");
			q.addEntity(Model.class);
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


}
