package p.lodz.pl.serwer;

import java.util.Date;

import p.lodz.pl.dao.AktualneDaoImpl;
import p.lodz.pl.encje.AktualneWypozyczenie;

public class AktualneEditService {
	public AktualneWypozyczenie edycja(AktualneWypozyczenie aw,
			Date DataZwrotu) {
		aw.setDataZwrotu(DataZwrotu);
		AktualneDaoImpl adi=new AktualneDaoImpl();
		try {
			aw=adi.update(aw);
		} catch (Exception e) {
			e.printStackTrace();
		}
				return aw;
		
	}

}
