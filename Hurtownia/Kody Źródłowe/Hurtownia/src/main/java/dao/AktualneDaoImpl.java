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
import encje.AktualneZamowienia;

public class AktualneDaoImpl implements AktualneDao{
	private static final Log log = LogFactory.getLog(AktualneDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public boolean AktualneExists(AktualneZamowienia az) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from AKTUALNE_ZAMOWIENIA where IDAKTUALNE='"
							+ az.getIDAKTUALNEZAMOWIENIE()+ "'");
			AktualneZamowienia c = (AktualneZamowienia) query.uniqueResult();
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
	public void save(AktualneZamowienia az) {
		log.debug("persisting AKTUALNE_ZAMOWIENIA instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(az);
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
	public Integer NewIdAktualne() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(IDAKTUALNE) FROM AKTUALNE_ZAMOWIENIA");
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
	public AktualneZamowienia findById(int id) {
		log.debug("getting AKTUALNE_ZAMOWIENIA instance with IDAKTUALNE: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			AktualneZamowienia result = (AktualneZamowienia) session.get(AktualneZamowienia.class, id);
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
	public List<AktualneZamowienia> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<AktualneZamowienia> List = new ArrayList<AktualneZamowienia>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from AKTUALNE_ZAMOWIENIA");
			q.addEntity(AktualneZamowienia.class);
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
	public void removeById(int idaz) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from AKTUALNE_ZAMOWIENIA where IDAKTUALNE=" + idaz);
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
	public List<AktualneZamowienia> findByIdkl(int idklient) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<AktualneZamowienia> lista= new ArrayList<AktualneZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from AKTUALNE_ZAMOWIENIA where IDKLIENT='"+ idklient+"'");
			q.addEntity(AktualneZamowienia.class);
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
	public List<AktualneZamowienia> findByIpr(int idpracownik) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<AktualneZamowienia> lista= new ArrayList<AktualneZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from AKTUALNE_ZAMOWIENIA where IDPRACOWNIK='"+ idpracownik+"'");
			q.addEntity(AktualneZamowienia.class);
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
	public List<AktualneZamowienia> findByIcz(int idczesc) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<AktualneZamowienia> lista= new ArrayList<AktualneZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from AKTUALNE_ZAMOWIENIA where IDCZESC='"+ idczesc+"'");
			q.addEntity(AktualneZamowienia.class);
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
	public AktualneZamowienia update(AktualneZamowienia c) {
		log.debug("merging AKTUALNE_ZAMOWIENIA");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			AktualneZamowienia result= (AktualneZamowienia) session.merge(c);
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
	public List<AktualneZamowienia> findBykcd(int idklient, int idczesc) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<AktualneZamowienia> lista= new ArrayList<AktualneZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from AKTUALNE_ZAMOWIENIA where idklient='"+ idklient+"'"
					+ "and idczesc='"+idczesc+"'and IDAKTUALNE in (select id from AKTUALNE_WIDOK ) fetch first 1 row only");
			q.addEntity(AktualneZamowienia.class);
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
	public void removeByIdkc(int idk, int idc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from AKTUALNE_ZAMOWIENIA where IDKLIENT=" + idk+" "
							+" and idczesc="+idc+" and IDAKTUALNE=("
									+"select id from AKTUALNE_WIDOK"
									+"order by id desc fetch first 1 row only)");
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
	public List<AktualneZamowienia> findBykcdp(int idklient, int idczesc,
			int idpracownik, int ilosc) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<AktualneZamowienia> lista= new ArrayList<AktualneZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from AKTUALNE_ZAMOWIENIA where idklient='"+ idklient+"'"
					+ "and idczesc='"+idczesc+"' and idpracownik='"+idpracownik+"'and IDAKTUALNE in (select id from AKTUALNE_WIDOK where "
							+ "id in (select id from HISTORIA_WIDOK where ilosc='"+ilosc+"')order by id desc fetch first 1 row only)");
			q.addEntity(AktualneZamowienia.class);
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
	public void removeById1(int idaz) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from AKTUALNE_ZAMOWIENIA where IDKOSZYK=" + idaz);
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
	public List<AktualneZamowienia> findByIk(int idkosz) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<AktualneZamowienia> lista= new ArrayList<AktualneZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from AKTUALNE_ZAMOWIENIA where IDKOSZYK='"+ idkosz+"'");
			q.addEntity(AktualneZamowienia.class);
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
