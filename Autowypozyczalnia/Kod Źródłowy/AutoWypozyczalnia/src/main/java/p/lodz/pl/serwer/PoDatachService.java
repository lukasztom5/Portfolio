package p.lodz.pl.serwer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import p.lodz.pl.encje.Auta;
import Hibernate.HibernateUtil;

public class PoDatachService {
	@SuppressWarnings("unchecked")
	public List<Auta> findautabydata(String data1, String data2){
		Session sess=HibernateUtil.getSessionFactory().openSession();
		Transaction t=null;
		List<Auta> listaAut= new ArrayList<Auta>();
		try{
			t=sess.getTransaction();
			t.begin();
			SQLQuery q = sess.createSQLQuery("select*from Auta where idauta not in (select autoid from aktualne_wypozyczenie) or idauta in (select autoid from aktualne_wypozyczenie where data_zwrotu <'"+data1+"'or data_rezerwacja>'"+data2+"')" );
			q.addEntity(Auta.class);
			listaAut = q.list();
			t.commit();
		}catch(Exception e){
			if(t!=null)
				t.rollback();
		}finally {
			sess.close();
		}
		return listaAut;
		
	}
}
