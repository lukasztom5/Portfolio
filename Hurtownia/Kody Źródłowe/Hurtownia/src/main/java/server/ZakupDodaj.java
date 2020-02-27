package server;


import dao.*;
import encje.*;

public class ZakupDodaj {
public boolean dodaj (Koszyk k){
	KoszykDaoImpl kdi = new KoszykDaoImpl();
	if(kdi.KoszykExists(k)){
		    return false;

	}
	try{
		kdi.save(k);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
	
}
}
