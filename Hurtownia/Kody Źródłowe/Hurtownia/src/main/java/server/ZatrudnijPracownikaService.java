package server;
import dao.AdministratorDaoImpl;
import dao.KlientDaoImpl;
import dao.PracownikDaoImpl;
import encje.Administrator;
import encje.Klient;
import encje.Pracownik;
import dao.*;
import encje.*;

public class ZatrudnijPracownikaService {
public boolean zatrudnienie (Pracownik pracownik){
	KlientDaoImpl kdi = new KlientDaoImpl();
	AdministratorDaoImpl adi = new AdministratorDaoImpl();
	PracownikDaoImpl pdi = new PracownikDaoImpl();
	Klient k = kdi.findbylogin(pracownik.getLOGIN());
	Pracownik p=pdi.findbylogin(pracownik.getLOGIN());
	Administrator a=adi.findbylogin(pracownik.getLOGIN());
	if(pdi.PracownikExists(pracownik)){
	    return false;
	}
	else if(a!=null && pracownik.getLOGIN().equals(a.getLOGIN())){
		return false;
	}
	else if(p!=null && pracownik.getLOGIN().equals(p.getLOGIN())){
		return false;
	}
	else if(k!=null && pracownik.getLOGIN().equals(k.getLOGIN())){
		return false;
	}
	else{
	try{
		pdi.save(pracownik);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
	}
}
public boolean dodawanie (Rozliczenie rozliczenie){
	RozliczenieDaoImpl adi=new RozliczenieDaoImpl();
	if (adi.RozliczenieExists(rozliczenie)){
	return false;
	}
	try{
		adi.save(rozliczenie);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
}
}
