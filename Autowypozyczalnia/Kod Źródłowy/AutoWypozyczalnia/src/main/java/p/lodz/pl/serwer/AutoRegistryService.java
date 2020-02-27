package p.lodz.pl.serwer;

import p.lodz.pl.dao.AutoDaoImpl;
import p.lodz.pl.encje.Auta;

public class AutoRegistryService {
public boolean Dodawanie (Auta auto){
	AutoDaoImpl adi=new AutoDaoImpl();
	if (adi.AutoExists(auto)){
	return false;
	}
	try{
		adi.save(auto);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
}
}
