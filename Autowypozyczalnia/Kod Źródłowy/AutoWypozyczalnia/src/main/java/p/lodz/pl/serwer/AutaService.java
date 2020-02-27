package p.lodz.pl.serwer;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import p.lodz.pl.encje.Auta;

public class AutaService {
	@SuppressWarnings("unchecked")
public List<Auta> getAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Auta> AutaLista=new ArrayList<Auta>();
		try{
			tx = session.getTransaction();
			tx.begin();
			AutaLista = session.createQuery("from Auta").list();
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	return AutaLista;
	
}
}
