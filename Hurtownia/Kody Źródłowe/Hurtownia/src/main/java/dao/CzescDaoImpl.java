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

public class CzescDaoImpl implements CzescDao{
	private static final Log log = LogFactory.getLog(CzescDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public boolean CzescExists(Czesc czesc) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from CZESC where IDCZESC='"
							+ czesc.getIDCZESC()+ "'");
			Czesc c = (Czesc) query.uniqueResult();
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
	public void save(Czesc czesc) {
		log.debug("persisting CZESC instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(czesc);
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
	public Integer NewIdCzesc() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(IDCZESC) FROM CZESC");
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
	public Czesc findById(int id) {
		log.debug("getting CZESC instance with IDCZESC: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Czesc result = (Czesc) session.get(Czesc.class, id);
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
	public List<Czesc> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Czesc> List = new ArrayList<Czesc>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from CZESC");
			q.addEntity(Czesc.class);
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
	public void removeById(int idczesc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from CZESC where IDCZESC=" + idczesc);
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
	public List<Czesc> findByIdkat(int idkategoria) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from CZESC where IDKATEGORIA='"+ idkategoria+"'");
			q.addEntity(Czesc.class);
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
	public List<Czesc> findByIdmod(int idmodel) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from CZESC where IDMODEL='"+ idmodel+"'");
			q.addEntity(Czesc.class);
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
	public Czesc update(Czesc c) {
		log.debug("merging CZESC");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Czesc result= (Czesc) session.merge(c);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Czesc> findBykat(String idkategoria) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from Czesc where IDMODEL in (select IDMODEL from Model where IDURZADZENIE=(select IDURZADZENIE from KATEGORIA where IDKATEGORIA in(select id from KAT_WIDOK where nazwa='"+ idkategoria+"')))");
			q.addEntity(Czesc.class);
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
	public List<Czesc> findBymodel(String idmodel) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from Czesc where IDMODEL in (select IDMODEL from Model where IDMODEL=(select id from MODEL_DANE where model='"+ idmodel+"'))");
			q.addEntity(Czesc.class);
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
	public List<Czesc> findtop() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Czesc> List = new ArrayList<Czesc>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from Czesc where IDCZESC in (select id from CZESC_WIDOK order by ilosc,id fetch first 6 row only)");
			q.addEntity(Czesc.class);
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

}
