package p.lodz.pl.serwer;
import p.lodz.pl.dao.AktualneDaoImpl;
import p.lodz.pl.dao.HistoriaDaoImpl;
import p.lodz.pl.encje.AktualneWypozyczenie;
import p.lodz.pl.encje.HistoriaWypozyczenia;

public class AktualneWypozyczService {
public boolean rejestracja (AktualneWypozyczenie aw){
	AktualneDaoImpl adi = new AktualneDaoImpl();
	if(adi.AktualneExists(aw)){
	    return false;
	}
	try{
		adi.save(aw);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
	
}
public boolean rejestracja (HistoriaWypozyczenia hw){
	HistoriaDaoImpl hdi = new HistoriaDaoImpl();
	if(hdi.HistoriaExists(hw)){
	    return false;
	}
	try{
		hdi.save(hw);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
	
}
}
