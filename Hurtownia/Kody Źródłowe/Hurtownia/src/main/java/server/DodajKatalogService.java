package server;
import dao.*;
import encje.*;

public class DodajKatalogService {
public boolean dodaj (Kategoria k){
	KategoriaDaoImpl mdi=new KategoriaDaoImpl();

	
	if(mdi.KategoriaExists(k) || k==null){
	    return false;
	}
	try{
		mdi.save(k);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
	
}
}
