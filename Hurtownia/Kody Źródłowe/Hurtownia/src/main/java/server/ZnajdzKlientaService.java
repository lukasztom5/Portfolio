package server;
import java.util.*;

import org.hibernate.*;

import Hibernate.HibernateUtil;
import encje.*;

public class ZnajdzKlientaService {
@SuppressWarnings("unchecked")
public List<Klient> findklientbycolumn(String column, String value){
	Session sess=HibernateUtil.getSessionFactory().openSession();
	Transaction t=null;
	List<Klient> lista= new ArrayList<Klient>();
	try{
		t=sess.getTransaction();
		t.begin();
		SQLQuery q = sess.createSQLQuery("select * from KLIENT where IDKLIENT in (select ID from KLIENT_DANE where "+column+" = "+"'"+value+"'"+")");
		q.addEntity(Klient.class);
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
