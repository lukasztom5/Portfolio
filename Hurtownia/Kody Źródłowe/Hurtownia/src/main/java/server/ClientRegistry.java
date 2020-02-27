package server;
import dao.*;
import encje.*;

public class ClientRegistry {
public boolean rejestracja (Klient klient){
	KlientDaoImpl kdi = new KlientDaoImpl();
	AdministratorDaoImpl adi = new AdministratorDaoImpl();
	PracownikDaoImpl pdi = new PracownikDaoImpl();
	Klient k = kdi.findbylogin(klient.getLOGIN());
	Pracownik p=pdi.findbylogin(klient.getLOGIN());
	Administrator a=adi.findbylogin(klient.getLOGIN());
	if(kdi.KlientExists(klient)){
	    return false;
	}
	else if(a!=null && klient.getLOGIN().equals(a.getLOGIN())){
		return false;
	}
	else if(p!=null && klient.getLOGIN().equals(p.getLOGIN())){
		return false;
	}
	else if(k!=null && klient.getLOGIN().equals(k.getLOGIN())){
		return false;
	}
	else{
	try{
		kdi.save(klient);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
	}
}
}
