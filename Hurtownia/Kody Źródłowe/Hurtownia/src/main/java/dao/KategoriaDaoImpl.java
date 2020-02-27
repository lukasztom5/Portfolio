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

public class KategoriaDaoImpl implements KategoriaDao{
	private static final Log log = LogFactory.getLog(KategoriaDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public boolean KategoriaExists(Kategoria kategoria) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from KATEGORIA where IDKATEGORIA='"
							+ kategoria.getIDKATEGORIA()+ "'");
			Kategoria c = (Kategoria) query.uniqueResult();
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
	public void save(Kategoria kategoria) {
		log.debug("persisting Kategoria instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(kategoria);
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
	public Integer NewIdKategoria() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(IDKATEGORIA) FROM KATEGORIA");
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
	public Kategoria findById(int id) {
		log.debug("getting KATEGORIA instance with IDKATEGORIA: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Kategoria result = (Kategoria) session.get(Kategoria.class, id);
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
	public List<Kategoria> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Kategoria> List = new ArrayList<Kategoria>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from KATEGORIA");
			q.addEntity(Kategoria.class);
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
	public void removeById(int idkategoria) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from KATEGORIA where IDKATEGORIA=" + idkategoria);
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
					.createSQLQuery("delete from KATEGORIA where IDURZADZENIE=" + idurzadzenie);
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
	public List<Kategoria> findByIdurzadz(int idurzadzenie) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Kategoria> lista= new ArrayList<Kategoria>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from KATEGORIA where IDURZADZENIE='"+ idurzadzenie+"'");
			q.addEntity(Kategoria.class);
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
	public List<Kategoria> findByurzadznazwa(String nazwa) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Kategoria> lista= new ArrayList<Kategoria>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from KATEGORIA where IDURZADZENIE=(select IDURZADZENIE from KATEGORIA where IDKATEGORIA in(select id from KAT_WIDOK where nazwa='"+ nazwa+"'))");
			q.addEntity(Kategoria.class);
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
	public List<Kategoria> findBymodelnazwa(String nazwa) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Kategoria> lista= new ArrayList<Kategoria>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from KATEGORIA where IDKATEGORIA in(select IDKATEGORIA from CZESC where idmodel in(select id from MODEL_DANE where model='"+ nazwa+"'))");
			q.addEntity(Kategoria.class);
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
	public Kategoria findBynazwa(String nazwa) {
		session = HibernateUtil.getSessionFactory().openSession();
		Kategoria sc = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Kategoria where idkategoria in (select id from KAT_WIDOK where nazwa='"
							+ nazwa
							+ "')");
			sc = (Kategoria) query.uniqueResult();
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
