package p.lodz.pl.serwer;
import p.lodz.pl.dao.HistoriaDaoImpl;
import p.lodz.pl.encje.HistoriaWypozyczenia;

public class HistoriaWypozyczService {
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
