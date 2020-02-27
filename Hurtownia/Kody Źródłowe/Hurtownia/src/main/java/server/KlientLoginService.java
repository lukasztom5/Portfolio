package server;

import dao.*;
import encje.*;

public class KlientLoginService {
public boolean login(String login, String haslo){
	AdministratorDaoImpl adi=new AdministratorDaoImpl();
	Administrator admin = adi.findbylogin(login);
	if(admin!=null && admin.getLOGIN().equals(login) && admin.getHASLO().equals(haslo))
		return true;
		else			
		
	return false;
	
}
public boolean login1(String login1, String haslo1){
	PracownikDaoImpl pdi = new PracownikDaoImpl();
	Pracownik prac=pdi.findbylogin(login1);
	if(prac!=null && prac.getLOGIN().equals(login1) && prac.getHASLO().equals(haslo1))	
		return true;
		else			
		
	return false;
	
}
public boolean login2(String login2, String haslo2){
	KlientDaoImpl kdi= new KlientDaoImpl();
	Klient klient = kdi.findbylogin(login2);
	if(klient!=null && klient.getLOGIN().equals(login2) && klient.getHASLO().equals(haslo2))
		return true;
	
	else 
			
		
	return false;
	
}
}
