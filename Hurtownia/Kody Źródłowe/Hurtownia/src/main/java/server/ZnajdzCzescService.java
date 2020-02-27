package server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.*;

public class ZnajdzCzescService {
	@SuppressWarnings("unchecked")
	public List<Czesc> findczescbykategoria(String value, String id){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from Czesc where IDMODEL in (select id from MODEL_DANE where model="+"'"+id+"'"+")) and IDKATEGORIA in(select id from KAT_WIDOK where nazwa='"+id+"') and IDCZESC in(select id FROM CZESC_WIDOK where ilosc>0)");
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
	public List<Czesc> findczescbycolumn(String value, String id){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from CZESC where IDCZESC in (select ID from CZESC_WIDOK where nazwa= "+"'"+value+"'"+") and idmodel in( select id from MODEL_DANE where model='"+id+"') "
					+ "and IDCZESC IN (select id FROM CZESC_WIDOK where ilosc>0)");
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
	public List<Czesc> findczescbycena(String cena1, String cena2,String id){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from CZESC where IDCZESC in (select ID from CZESC_WIDOK where CENA BETWEEN "+"'"+cena1+"' AND"+"'"+cena2+"') and idmodel in( select id from MODEL_DANE where model='"+id+"') "
					+ "and IDCZESC IN (select id FROM CZESC_WIDOK where ilosc>0)");
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
	public List<Czesc> findczescbycena1(String cena1, String cena2,String id){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from CZESC where IDCZESC in (select ID from CZESC_WIDOK where CENA BETWEEN '"+cena1+"' AND"+"'"+cena2+"' and ilosc>0 ) and IDKATEGORIA in(select id from KAT_WIDOK where nazwa='"+id+"')");
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
	public List<Czesc> findczescbymodel(String value, String id){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from CZESC where IDKATEGORIA in (select ID from KAT_WIDOK where nazwa="+"'"+value+"'"+") and IDMODEL in (select id from MODEL_DANE where model='"+id+"') and IDCZESC IN (select id FROM CZESC_WIDOK where ilosc>0)");
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
	public List<Czesc> findczescbyfirma(String value, String id){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from CZESC where IDKATEGORIA in (select ID from KAT_WIDOK where NAZWA='"+value+"')and IDMODEL in (select ID from MODEL_DANE where FIRMA='"+id+"') and IDCZESC IN (select ID FROM CZESC_WIDOK where ILOSC>0)");
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
	public List<Czesc> findczescbycolumn1(String value, String id){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Czesc> lista= new ArrayList<Czesc>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from CZESC where IDKATEGORIA in (select ID from KAT_WIDOK where nazwa='"+value+"'"+")and IDCZESC IN (select id FROM CZESC_WIDOK where ilosc>0 and nazwa='"+id+"')");
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
	
	
}
