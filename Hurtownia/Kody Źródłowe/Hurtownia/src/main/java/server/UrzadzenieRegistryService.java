package server;
import dao.*;
import encje.*;

public class UrzadzenieRegistryService {
public boolean dodaj (Urzadzenie urzadzenie){
	UrzadzenieDaoImpl udi = new UrzadzenieDaoImpl();
	if(udi.UrzadzenieExists(urzadzenie)){
	    return false;
	}
	try{
		udi.save(urzadzenie);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
	
}
}
