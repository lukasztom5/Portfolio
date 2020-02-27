package p.lodz.pl.serwer;


import p.lodz.pl.dao.HistoriaDaoImpl;
import p.lodz.pl.encje.HistoriaWypozyczenia ;
public class UsunAktualneService {
	public HistoriaWypozyczenia edycja(HistoriaWypozyczenia hw,double CenaCalosc,int Kilometry,String uwagi, Double dodatkowyKoszt){
		hw.setKilometry(Kilometry);
		hw.setUwagi(uwagi);
		hw.setDodatkowyKoszt(dodatkowyKoszt);
		hw.setStawkaSegmentWyposazenie(CenaCalosc);
		HistoriaDaoImpl hdi=new HistoriaDaoImpl();
		try {
			hw=hdi.update(hw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				return hw;
		
}
}
