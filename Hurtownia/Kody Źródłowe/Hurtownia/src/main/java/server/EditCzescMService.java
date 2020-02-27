package server;

import dao.*;
import encje.*;
public class EditCzescMService {
	public Czesc edycja(Czesc c, String dane){
		c.setDANE(dane);
		CzescDaoImpl kdi=new CzescDaoImpl();
		try {
			c=kdi.update(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				return c;
		
}
}
