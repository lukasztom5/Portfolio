package server;

import dao.*;
import encje.*;

public class DodajCzescMService {
	public boolean dodaj (Czesc c){
		CzescDaoImpl mdi=new CzescDaoImpl();
		if(mdi.CzescExists(c)){
		    return false;
		}
		try{
			mdi.save(c);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
		
	}
}
