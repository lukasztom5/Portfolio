package server;
import java.util.*;

import org.hibernate.*;

import Hibernate.HibernateUtil;
import encje.*;

public class ZnajdzPracownikaService {
@SuppressWarnings("unchecked")
public List<Pracownik> findpracownikbycolumn(String column, String value){
	Session sess=HibernateUtil.getSessionFactory().openSession();
	Transaction t=null;
	List<Pracownik> lista= new ArrayList<Pracownik>();
	try{
		t=sess.getTransaction();
		t.begin();
		SQLQuery q = sess.createSQLQuery("select * from PRACOWNIK where IDPRACOWNIK in (select ID from PRAC_DANE where "+column+" = "+"'"+value+"'"+")");
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
public List<Pracownik> findpracownikbypensje(String pensja1, String pensja2){
	Session sess=HibernateUtil.getSessionFactory().openSession();
	Transaction t=null;
	List<Pracownik> lista= new ArrayList<Pracownik>();
	try{
		t=sess.getTransaction();
		t.begin();
		SQLQuery q = sess.createSQLQuery("select * from PRACOWNIK where IDPRACOWNIK in (select ID from PRAC_DANE where PENSJA BETWEEN '"+pensja1+"' and '"+pensja2+"')" );
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
public List<Pracownik> findpracownikbydata(String data1, String data2){
	Session sess=HibernateUtil.getSessionFactory().openSession();
	Transaction t=null;
	List<Pracownik> lista= new ArrayList<Pracownik>();
	try{
		t=sess.getTransaction();
		t.begin();
		SQLQuery q = sess.createSQLQuery("select * from PRACOWNIK where IDPRACOWNIK in (select ID from PRAC_DANE where DATA_ZATRUDNIENIA BETWEEN'"+data1+"' and '"+data2+"')" );
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
}
