package server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.*;

public class KatalogDodaj {
	@SuppressWarnings("unchecked")
	public List<Urzadzenie> findbynazwa(String value){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Urzadzenie> lista= new ArrayList<Urzadzenie>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from URZADZENIE where IDURZADZENIE in(select id from URZADZENIE_DANE where nazwa="+"'"+value+"'"+")");
			q.addEntity(Urzadzenie.class);
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
	public List<Model> findbynazwa1(String value){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Model> lista= new ArrayList<Model>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from MODEL where IDMODEL in(select id from MODEL_DANE where model="+"'"+value+"'"+")");
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
	public List<Kategoria> findbynazwa2(String value){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Kategoria> lista= new ArrayList<Kategoria>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select * from Kategoria where IDkategoria in(select id from KAT_WIDOK where nazwa="+"'"+value+"'"+")");
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
	
}
