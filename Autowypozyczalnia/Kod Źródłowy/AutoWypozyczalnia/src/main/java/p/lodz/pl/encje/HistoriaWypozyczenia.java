package p.lodz.pl.encje;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="historia_wypozyczenia")
@NamedQuery(name="HistoriaWypozyczenia.findAll", query="SELECT h FROM HistoriaWypozyczenia h")
public class HistoriaWypozyczenia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name="idhistoria_wypozyczenia", unique = true, nullable = false, precision = 4, scale = 0)
	private int idhistoria_wypozyczenia;
	@Column(name="klientid", unique = true, nullable = false, precision = 4, scale = 0)
	private int klientid;
	
	@Column(name="autoid", unique = true, nullable = false, precision = 4, scale = 0)
	private int autoid;
	
	@Column(name="marka", length=100)
	private String marka;
	
	@Column(name="model", length=100)
	private String model;
	
	@Column(name="imie", length=100)
	private String imie;
	
	@Column(name="nazwisko", length=100)
	private String nazwisko;
	
	@Column(name="wyposazenie", length=1000)
	private String wyposazenie;
	
	@Column(name="uwagi", length=3000)
	private String uwagi;
	
	@Column(name="cena_segment")
	private int cenaSegment;
	
	@Column(name="liczba_dni")
	private int liczbaDni;
	
	@Column(name="stawka_segment_wyposazenie")
	private double stawkaSegmentWyposazenie;
	
	@Column(name="cena_dodatek")
	private double cenaDodatek;
	
	@Column(name="dodatkowy_koszt")
	private double dodatkowyKoszt;
	
	@Column(name="kilometry")
	private int kilometry;
	
	@Column(name="termin_oddania")
	private Date terminOddania;
	
	@Column(name="termin_wypozyczenia")
	private Date terminWypozyczenia;
	
	@Column(name="status_zaliczka")
	private String statusZaliczka;
	
	@Column(name="idauta")
	private Auta auta;
	
	@Column(name="idklient")
	private Klient klient;
	
	@Column(name="idadministrator")
	private Administrator administrator;

	public HistoriaWypozyczenia() {
	}
	public HistoriaWypozyczenia(int idhistoria_wypozyczenia,Auta auta, Klient klient, Administrator administrator,Date terminWypozyczenia,
			Date terminOddania,String dzienOddania,int liczba_dni,int cenaSegment,double stawkaSegmentWyposazenie){	
		this.idhistoria_wypozyczenia=idhistoria_wypozyczenia;
		this.auta=auta;
		this.klient=klient;
		this.administrator=administrator;
		this.terminWypozyczenia=terminWypozyczenia;
		this.terminOddania=terminOddania;
		this.cenaSegment=cenaSegment;
		this.stawkaSegmentWyposazenie=stawkaSegmentWyposazenie;
		
		}
	public HistoriaWypozyczenia(int idhistoria_wypozyczenia,int klientid,int autoid,String marka, String model, String imie, String nazwisko,Date terminWypozyczenia,
			Date terminOddania,int liczbaDni,int cenaSegment, double cenaDodatek,String wyposazenie, double stawkaSegmentWyposazenie){	
		this.idhistoria_wypozyczenia=idhistoria_wypozyczenia;
		this.autoid=autoid;
		this.klientid=klientid;
		this.marka=marka;
		this.model=model;
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.terminWypozyczenia=terminWypozyczenia;
		this.terminOddania=terminOddania;
		this.liczbaDni=liczbaDni;
		this.cenaSegment=cenaSegment;
		this.cenaDodatek=cenaDodatek;
		this.wyposazenie=wyposazenie;
		this.stawkaSegmentWyposazenie=stawkaSegmentWyposazenie;
		}
	public HistoriaWypozyczenia(int idhistoria_wypozyczenia,int klientid,int autoid,String marka, String model, String imie, String nazwisko,Date terminWypozyczenia,
			Date terminOddania){	
		this.idhistoria_wypozyczenia=idhistoria_wypozyczenia;
		this.autoid=autoid;
		this.klientid=klientid;
		this.marka=marka;
		this.model=model;
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.terminWypozyczenia=terminWypozyczenia;
		this.terminOddania=terminOddania;
		}
	public HistoriaWypozyczenia(int idhistoria_wypozyczenia,int klientid,int autoid,String marka, String model, String imie, String nazwisko,Date terminWypozyczenia,
			Date terminOddania,int liczbaDni,int cenaSegment, double cenaDodatek,String wyposazenie, double stawkaSegmentWyposazenie,String statusZaliczka,
			int kilometry, String uwagi, double dodatkowyKoszt){	
		this.idhistoria_wypozyczenia=idhistoria_wypozyczenia;
		this.autoid=autoid;
		this.klientid=klientid;
		this.marka=marka;
		this.model=model;
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.terminWypozyczenia=terminWypozyczenia;
		this.terminOddania=terminOddania;
		this.liczbaDni=liczbaDni;
		this.cenaSegment=cenaSegment;
		this.cenaDodatek=cenaDodatek;
		this.wyposazenie=wyposazenie;
		this.stawkaSegmentWyposazenie=stawkaSegmentWyposazenie;
		this.statusZaliczka=statusZaliczka;
		this.kilometry=kilometry;
		this.dodatkowyKoszt=dodatkowyKoszt;
		this.uwagi=uwagi;
		
		}
	public Object getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}
	public Object getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public Object getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}
	public Object getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
	public int getIdhistoriaWypozyczenia() {
		return this.idhistoria_wypozyczenia;
	}

	public void setIdhistoriaWypozyczenia(int idhistoria_wypozyczenia) {
		this.idhistoria_wypozyczenia = idhistoria_wypozyczenia;
	}

	public int getAutoId() {
		return this.autoid;
	}

	public void setAutoId(int autoid) {
		this.autoid = autoid;
	}
	public int getKlientid() {
		return this.klientid;
	}

	public void setKlientid(int klientid) {
		this.klientid = klientid;
	}
	public double getCenaSegment() {
		return this.cenaSegment;
	}

	public void setCenaSegment(int cenaSegment) {
		this.cenaSegment = cenaSegment;
	}
	public double getCenaDodatek() {
		return this.cenaDodatek;
	}

	public void setCenaDodatek(double cenaDodatek) {
		this.cenaDodatek = cenaDodatek;
	}
	public Object getStatusZaliczka() {
		return this.statusZaliczka;
	}

	public void setStatusZaliczka(String statusZaliczka) {
		this.statusZaliczka = statusZaliczka;
	}

	public int getLiczbaDni() {
		return this.liczbaDni;
	}

	public void setLiczbaDni(int liczbaDni) {
		this.liczbaDni = liczbaDni;
	}

	public double getStawkaSegmentWyposazenie() {
		return this.stawkaSegmentWyposazenie;
	}

	public void setStawkaSegmentWyposazenie(double stawkaSegmentWyposazenie) {
		this.stawkaSegmentWyposazenie = stawkaSegmentWyposazenie;
	}

	public Object getTerminOddania() {
		return this.terminOddania;
	}

	public void setTerminOddania(Date terminOddania) {
		this.terminOddania = terminOddania;
	}

	public Object getTerminWypozyczenia() {
		return this.terminWypozyczenia;
	}

	public void setTerminWypozyczenia(Date terminWypozyczenia) {
		this.terminWypozyczenia = terminWypozyczenia;
	}
	public Object getWyposazenie() {
		return this.wyposazenie;
	}

	public void setWyposazenie(String wyposazenie) {
		this.wyposazenie = wyposazenie;
	}
	public Object getUwagi() {
		return this.uwagi;
	}

	public void setUwagi(String uwagi) {
		this.uwagi = uwagi;
	}
	public int getKilometry() {
		return this.kilometry;
	}

	public void setKilometry(int kilometry) {
		this.kilometry = kilometry;
	}
	public double getDodatkowyKoszt() {
		return this.dodatkowyKoszt;
	}

	public void setDodatkowyKoszt(double dodatkowyKoszt) {
		this.dodatkowyKoszt = dodatkowyKoszt;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idauta")
	public Auta getAuta() {
		return auta;
	}
	public void setAuta(Auta auta) {
		this.auta = auta;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idklient")
	public Klient getKlient() {
		return klient;
	}
	public void setKlient(Klient klient) {
		this.klient = klient;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idadministrator")
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

}