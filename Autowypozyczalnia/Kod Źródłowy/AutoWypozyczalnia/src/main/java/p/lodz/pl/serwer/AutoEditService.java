package p.lodz.pl.serwer;

import p.lodz.pl.dao.AutoDaoImpl;
import p.lodz.pl.encje.Auta;


public class AutoEditService {
	public Auta AutaEdit(Auta auto, String marka, String model, String segment, String paliwo, String skrzynia_biegow,
			String numer_rejestracyjny, String numer_VIN, String numer_nadwozia, String numer_silnika, String rocznik, String kolor, String moc_silnika_KM,
			String naped_na_kola, String liczba_miejsc, String liczba_drzwi, String pojemnosc_bagaznika_w_litrach, String zuzycie_paliwa_na_100_km)
	{
		auto.setMarka(marka);
		auto.setModel(model);
		auto.setSegment(segment);
		auto.setPaliwo(paliwo);
		auto.setSkrzyniaBiegow(skrzynia_biegow);
		auto.setNumerRejestracyjny(numer_rejestracyjny);
		auto.setNumer_VIN(numer_VIN);
		auto.setNumerNadwozia(numer_nadwozia);
		auto.setNumerSilnika(numer_silnika);
		auto.setRocznik(rocznik);
		auto.setKolor(kolor);
		auto.setMoc_silnika_KM(moc_silnika_KM);
		auto.setNapedNaKola(naped_na_kola);
		auto.setLiczbaMiejsc(liczba_miejsc);
		auto.setLiczbaDrzwi(liczba_drzwi);
		auto.setPojemnoscBagaznikaWLitrach(pojemnosc_bagaznika_w_litrach);
		auto.setZuzyciePaliwaNa100Km(zuzycie_paliwa_na_100_km);
		
		AutoDaoImpl adi=new AutoDaoImpl();
		auto= adi.update(auto);
		return auto;
	}
}
