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
import encje.HistoriaZamowienia;

public class HistoriaDaoImpl implements HistoriaDao{
	private static final Log log = LogFactory.getLog(HistoriaDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public boolean HistoriaExists(HistoriaZamowienia hz) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from HISTORIA_ZAMOWIENIA where IDHISTORIA='"
							+ hz.getIDHISTORIAZAMOWIENIA()+ "'");
			HistoriaZamowienia c = (HistoriaZamowienia) query.uniqueResult();
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
	public void save(HistoriaZamowienia hz) {
		log.debug("persisting HISTORIA_ZAMOWIENIA instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(hz);
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
	public Integer NewIdHistoria() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("select max(IDHISTORIA) FROM HISTORIA_ZAMOWIENIA");
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
	public HistoriaZamowienia findById(int id) {
		log.debug("getting HISTORIA_ZAMOWIENIA instance with IDHISTORIA: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			HistoriaZamowienia result = (HistoriaZamowienia) session.get(HistoriaZamowienia.class, id);
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
	public List<HistoriaZamowienia> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<HistoriaZamowienia> List = new ArrayList<HistoriaZamowienia>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from HISTORIA_ZAMOWIENIA");
			q.addEntity(HistoriaZamowienia.class);
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
	public void removeById(int idhz) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createSQLQuery("delete from HISTORIA_ZAMOWIENIA where IDHISTORIA=" + idhz);
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
	public List<HistoriaZamowienia> findByIdkl(int idklient) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<HistoriaZamowienia> lista= new ArrayList<HistoriaZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from HISTORIA_ZAMOWIENIA where IDKLIENT='"+ idklient+"'");
			q.addEntity(HistoriaZamowienia.class);
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
	public List<HistoriaZamowienia> findByIpr(int idpracownik) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<HistoriaZamowienia> lista= new ArrayList<HistoriaZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from HISTORIA_ZAMOWIENIA where IDPRACOWNIK='"+ idpracownik+"'");
			q.addEntity(HistoriaZamowienia.class);
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
	public List<HistoriaZamowienia> findByIcz(int idczesc) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<HistoriaZamowienia> lista= new ArrayList<HistoriaZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from HISTORIA_ZAMOWIENIA where IDCZESC='"+ idczesc+"'");
			q.addEntity(HistoriaZamowienia.class);
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
	public HistoriaZamowienia update(HistoriaZamowienia c) {
		log.debug("merging HISTORIA_ZAMOWIENIA");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			HistoriaZamowienia result= (HistoriaZamowienia) session.merge(c);
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
	public List<HistoriaZamowienia> findhi() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<HistoriaZamowienia> List = new ArrayList<HistoriaZamowienia>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from Czesc where IDCZESC in (select id from CZESC_WIDOK order by ilosc,id fetch first 10 row only)");
			q.addEntity(HistoriaZamowienia.class);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriaZamowienia> findhi1(int ic) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<HistoriaZamowienia> lista= new ArrayList<HistoriaZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from HISTORIA_ZAMOWIENIA where IDCZESC='"+ ic+"'"
					+ " and idhistoria not in ("
					+ " select id from HISTORIA_WIDOK where status like '%Odrzucone%' or status like '%Anulowano%' "
					+ "or status like '%Przekazane%' or status like '%Weryfikacja%') and idhistoria in ("
					+ " select id from HISTORIA_WIDOK where year(data_zamowienia)=year((SELECT current date FROM sysibm.sysdummy1)) and "
					+ "month(data_zamowienia)=month((SELECT current date FROM sysibm.sysdummy1)))");
			q.addEntity(HistoriaZamowienia.class);
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
	public List<HistoriaZamowienia> findhi2(int im) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<HistoriaZamowienia> lista= new ArrayList<HistoriaZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from HISTORIA_ZAMOWIENIA where idhistoria not in ("
					+ " select id from HISTORIA_WIDOK where status like '%Odrzucone%' or status like '%Anulowano%'"
					+ " or status like '%Przekazane%' or status like '%Weryfikacja%'"
					+ ") and idczesc in (select idczesc from czesc where idmodel="+im+") "
							+ "and idhistoria in (select id from HISTORIA_WIDOK where year(data_zamowienia)=year((SELECT current date FROM sysibm.sysdummy1)) "
							+ "and month(data_zamowienia)=month((SELECT current date FROM sysibm.sysdummy1)))");
			q.addEntity(HistoriaZamowienia.class);
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
	public List<HistoriaZamowienia> findhi3(int im, int m) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<HistoriaZamowienia> lista= new ArrayList<HistoriaZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from HISTORIA_ZAMOWIENIA where idhistoria not in ("
					+ " select id from HISTORIA_WIDOK where status like '%Odrzucone%' or status like '%Anulowano%'"
					+ " or status like '%Przekazane%' or status like '%Weryfikacja%'"
					+ " ) and idhistoria in (select id from HISTORIA_WIDOK where month(data_zamowienia)="+m+" and"
							+ " year(data_zamowienia)=year((SELECT current date FROM sysibm.sysdummy1))"
					+ " and idczesc in (select idczesc from czesc where idmodel="+im+"))");
			q.addEntity(HistoriaZamowienia.class);
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
	public List<HistoriaZamowienia> findhi4(int im, int y) {
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<HistoriaZamowienia> lista= new ArrayList<HistoriaZamowienia>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from HISTORIA_ZAMOWIENIA where idhistoria not in ("
					+ " select id from HISTORIA_WIDOK where status like '%Odrzucone%' or status like '%Anulowano%'"
					+ " or status like '%Przekazane%' or status like '%Weryfikacja%'"
					+ " ) and idhistoria in (select id from HISTORIA_WIDOK where "
							+ " year(data_zamowienia)='"+y+"')"
					+ " and idczesc in (select idczesc from czesc where idmodel="+im+")");
			q.addEntity(HistoriaZamowienia.class);
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
