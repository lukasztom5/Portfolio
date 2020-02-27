package server;

import dao.*;
import encje.*;

public class DodajZamowienieService {
	public boolean dodaj1 (AktualneZamowienia k){
		AktualneDaoImpl mdi=new AktualneDaoImpl();
		if(mdi.AktualneExists(k)){
		    return false;
		}
		try{
			mdi.save(k);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
		
	}
	public boolean dodaj2 (HistoriaZamowienia k){
		HistoriaDaoImpl mdi=new HistoriaDaoImpl();
		if(mdi.HistoriaExists(k)){
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
