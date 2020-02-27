package server;

import dao.*;
import encje.*;
public class KlientModifyService {
	public Klient edycja(Klient k,String Dane,String Login,String Haslo){
		k.setDANE(Dane);
		k.setLOGIN(Login);
		k.setHASLO(Haslo);
		KlientDaoImpl kdi = new KlientDaoImpl();

		try {
			k=kdi.update(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				return k;
		
}
	
}
