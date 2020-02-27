package p.lodz.pl.serwer;
import p.lodz.pl.dao.KlientDaoImpl;
import p.lodz.pl.encje.Klient;

public class KlientRegistryService {
public boolean rejestracja (Klient klient){
	KlientDaoImpl kdi = new KlientDaoImpl();
	if(kdi.KlientExists(klient)){
	    return false;
	}
	try{
		kdi.save(klient);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
	
}
}
