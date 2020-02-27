package server;

import dao.PracownikDaoImpl;
import encje.Pracownik;
public class PracownikModifyService {
	public Pracownik edycja(Pracownik k,String Dane,String Login,String Haslo){
		k.setUMOWA(Dane);
		k.setLOGIN(Login);
		k.setHASLO(Haslo);
		PracownikDaoImpl kdi=new PracownikDaoImpl();
		try {
			k=kdi.update(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				return k;
		
}
}
