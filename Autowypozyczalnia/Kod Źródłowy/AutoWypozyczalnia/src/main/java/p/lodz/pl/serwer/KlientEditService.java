package p.lodz.pl.serwer;

import p.lodz.pl.dao.KlientDaoImpl;
import p.lodz.pl.encje.Klient;

public class KlientEditService {
	public Klient KlientEdit(Klient klient, String imie, String nazwisko, String pesel, 
			String miasto, String adres, String adres_mail, String telefon, String login, String haslo){
		klient.setImie(imie);
		klient.setNazwisko(nazwisko);
		klient.setPesel(pesel);
		klient.setMiasto(miasto);
		klient.setAdres(adres_mail);
		klient.setAdresMail(adres_mail);
		klient.setTelefon(telefon);
		klient.setLogin(login);
		klient.setHaslo(haslo);
		KlientDaoImpl kdi=new KlientDaoImpl();
			klient=kdi.update(klient);
			return klient;
		
	}
}
