package p.lodz.pl.serwer;

import java.util.Date;

import p.lodz.pl.dao.HistoriaDaoImpl;
import p.lodz.pl.encje.HistoriaWypozyczenia ;
public class HistoriaEditService {
	public HistoriaWypozyczenia edycja(HistoriaWypozyczenia hw,Date terminOddania,
			int liczbaDni,double CenaCalosc,String statusZaliczka,int Kilometry,String uwagi, Double dodatkowyKoszt){
		hw.setTerminOddania(terminOddania);
		hw.setLiczbaDni(liczbaDni);
		hw.setStawkaSegmentWyposazenie(CenaCalosc);
		hw.setStatusZaliczka(statusZaliczka);
		hw.setKilometry(Kilometry);
		hw.setUwagi(uwagi);
		hw.setDodatkowyKoszt(dodatkowyKoszt);
		HistoriaDaoImpl hdi=new HistoriaDaoImpl();
		try {
			hw=hdi.update(hw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				return hw;
		
}
}
