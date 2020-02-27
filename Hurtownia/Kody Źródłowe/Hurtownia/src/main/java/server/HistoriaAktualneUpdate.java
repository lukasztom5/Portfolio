package server;

import dao.*;
import encje.*;

public class HistoriaAktualneUpdate {
	public HistoriaZamowienia edycja(HistoriaZamowienia c, String potwierdzenie){
		c.setPOTWIERDZENIE(potwierdzenie);
		HistoriaDaoImpl kdi=new HistoriaDaoImpl();
		try {
			c=kdi.update(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				return c;
		
}
	public AktualneZamowienia edycja(AktualneZamowienia c, String potwierdzenie){
		c.setPOTWIERDZENIE(potwierdzenie);
		AktualneDaoImpl kdi=new AktualneDaoImpl();
		try {
			c=kdi.update(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				return c;
		
}
	public HistoriaZamowienia edycja(HistoriaZamowienia c, Pracownik p,String dane){
		c.setIDPRACOWNIK(p);
		c.setPOTWIERDZENIE(dane);
		HistoriaDaoImpl kdi=new HistoriaDaoImpl();
		try {
			c=kdi.update(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				return c;

}	
	public AktualneZamowienia edycja(AktualneZamowienia c, Pracownik p,String dane){
		c.setIDPRACOWNIK(p);
		c.setPOTWIERDZENIE(dane);
		AktualneDaoImpl kdi=new AktualneDaoImpl();
		try {
			c=kdi.update(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				return c;
		
}

}
