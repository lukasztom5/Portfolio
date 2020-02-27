package p.lodz.pl.serwer;
import p.lodz.pl.dao.KlientDaoImpl;
import p.lodz.pl.encje.Klient;

public class KlientLoginService {
public boolean login(int idklient, String login, String haslo){
	KlientDaoImpl kdi= new KlientDaoImpl();
	Klient klient=kdi.findById(idklient);
	if(klient!=null && klient.getIdklient()==idklient && klient.getLogin().equals(login) && klient.getHaslo().equals(haslo))
		return true;
	else
		
	return false;
	
}
}
