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
import encje.Pracownik;
import encje.Administrator;

public class PracownikDaoImpl implements PracownikDao{
	private static final Log log = LogFactory.getLog(PracownikDaoImpl.class);

	private Session session;
	private Transaction tx;
	
	public void save(Pracownik pracownik) {
		log.debug("persisting PRACOWNIK instance");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.save(pracownik);
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
	public Pracownik findById(int id) {
		log.debug("getting PRACOWNIK instance with id: " + id);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Pracownik result = (Pracownik) session.get(Pracownik.class, id);
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
	@Override
	public Pracownik update(Pracownik pracownik){
		log.debug("merging PRACOWNIK");
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Pracownik result= (Pracownik) session.merge(pracownik);
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
	public boolean PracownikExists(Pracownik pracownik) {
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from PRACOWNIK where IDPRACOWNIK='"
							+ pracownik.getIDPRACOWNIK()+ "'");
			Pracownik c = (Pracownik) query.uniqueResult();
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

		public Integer NewIdPracownik() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			Integer result = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session
						.createSQLQuery("select max(IDPRACOWNIK) FROM PRACOWNIK");
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
		@SuppressWarnings("unchecked")
		public List<Pracownik> findAll() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			List<Pracownik> List = new ArrayList<Pracownik>();
			try {
				tx = session.getTransaction();
				tx.begin();
				SQLQuery q = session.createSQLQuery(
						"select * from PRACOWNIK");
				q.addEntity(Pracownik.class);
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
		public List<Pracownik> findByIdAdmin(Administrator id){
			Session sess=HibernateUtil.getSessionFactory().openSession();
			Transaction t=null;
			List<Pracownik> lista= new ArrayList<Pracownik>();
			try{
				t=sess.getTransaction();
				t.begin();
				SQLQuery q = sess.createSQLQuery("select*from PRACOWNIK where IDADMINISTATOR='"+ id.getIDADMINISTRATOR()+"'");
				q.addEntity(Pracownik.class);
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
		public void removeById(int idpracownik) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session
						.createSQLQuery("delete from PRACOWNIK where IDPRACOWNIK=" + idpracownik);
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
		public Pracownik findbylogin(String login) {
			session = HibernateUtil.getSessionFactory().openSession();
			Pracownik sc = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session
						.createQuery("from Pracownik where login='"
								+ login
								+ "'");
				sc = (Pracownik) query.uniqueResult();
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
		@SuppressWarnings("unchecked")
		@Override
		public List<Pracownik> findbykod(String kod) {
				Session sess=HibernateUtil.getSessionFactory().openSession();
				Transaction t=null;
				List<Pracownik> lista= new ArrayList<Pracownik>();
				try{
					t=sess.getTransaction();
					t.begin();
					SQLQuery q = sess.createSQLQuery("select * from PRACOWNIK where IDpracownik=(select id from PRAC_DANE where kod='"+ kod+"')");
					q.addEntity(Pracownik.class);
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
		public List<Pracownik> findwithoutid(int id) {
			Session sess=HibernateUtil.getSessionFactory().openSession();
			Transaction t=null;
			List<Pracownik> lista= new ArrayList<Pracownik>();
			try{
				t=sess.getTransaction();
				t.begin();
				SQLQuery q = sess.createSQLQuery("select * from PRACOWNIK where IDpracownik<>"+ id);
				q.addEntity(Pracownik.class);
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
		public List<Pracownik> findtop1() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			List<Pracownik> List = new ArrayList<Pracownik>();
			try {
				tx = session.getTransaction();
				tx.begin();
				SQLQuery q = session.createSQLQuery(
						"select * from pracownik where idpracownik not in (select IDPRACOWNIK from AKTUALNE_ZAMOWIENIA "
+"where IDAKTUALNE in (select id from AKTUALNE_WIDOK where month(data_zamowienia)=month((SELECT current date FROM sysibm.sysdummy1))" 
+"and year(data_zamowienia)=year((SELECT current date FROM sysibm.sysdummy1)))"
+"group by IDPRACOWNIK having count(IDAKTUALNE)>0) fetch first 1 row only");
				q.addEntity(Pracownik.class);
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
		public List<Pracownik> findtop1a() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			List<Pracownik> List = new ArrayList<Pracownik>();
			try {
				tx = session.getTransaction();
				tx.begin();
				SQLQuery q = session.createSQLQuery(
						"select * from PRACOWNIK where IDPRACOWNIK not in (select IDPRACOWNIK from AKTUALNE_ZAMOWIENIA "
+"where IDAKTUALNE in (select id from AKTUALNE_WIDOK where month(data_zamowienia)=month((SELECT current date FROM sysibm.sysdummy1)) "
+"and year(data_zamowienia)=year((SELECT current date FROM sysibm.sysdummy1)))group by IDPRACOWNIK having count(IDPRACOWNIK)=0) fetch first 1 row only");
				q.addEntity(Pracownik.class);
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
