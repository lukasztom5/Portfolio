package p.lodz.pl.encje;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="auta")
public class Auta implements Serializable {

	private static final long serialVersionUID = 8498342128001463213L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name="idauta", unique = true, nullable = false)
	private int idauta;
	@Column(name="kolor", length=50)
	private String kolor;
	@Column(name="liczba_drzwi", length=50)
	private String liczbaDrzwi;
	@Column(name="liczba_miejsc", length=50)
	private String liczbaMiejsc;
	@Column(name="marka", length=50)
	private String marka;
	@Column(name="moc_silnika_KM", length=50)
	private String moc_silnika_KM;
	@Column(name="model", length=50)
	private String model;
	@Column(name="naped_na_kola", length=100)
	private String napedNaKola;
	@Column(name="numer_nadwozia", length=50)
	private String numerNadwozia;
	@Column(name="numer_rejestracyjny", length=50)
	private String numerRejestracyjny;
	@Column(name="numer_silnika", length=50)
	private String numerSilnika;
	@Column(name="numer_VIN", length=50)
	private String numer_VIN;
	@Column(name="paliwo", length=50)
	private String paliwo;
	@Column(name="pojemnosc_bagaznika_w_litrach", length=50)
	private String pojemnoscBagaznikaWLitrach;
	@Column(name="rocznik", length=50)
	private String rocznik;
	@Column(name="segment", length=50)
	private String segment;
	@Column(name="skrzynia_biegow", length=50)
	private String skrzyniaBiegow;
	@Column(name="zuzycie_paliwa_na_100_km", length=50)
	private String zuzyciePaliwaNa100Km;
	@Column(name="idadministrator")
	private Administrator a;
	@Column(name="idmarka")
	private Marka m;
	@Column(name="idkolor")
	private Kolor k;
	@Column(name="idsegment")
	private Segment s;
	public Auta() {
	}
	public Auta(int idauta, String marka, String model, String segment, String paliwo, String skrzyniaBiegow, String kolor, String moc_silnika_KM,
			String napedNaKola, String liczbaMiejsc, String liczbaDrzwi, String pojemnoscBagaznikaWLitrach, String zuzyciePaliwaNa100Km){
		this.idauta = idauta;
		this.marka=marka;
		this.model=model;
		this.segment = segment;
		this.skrzyniaBiegow = skrzyniaBiegow;
		this.kolor = kolor;
		this.moc_silnika_KM = moc_silnika_KM;
		this.napedNaKola = napedNaKola;
		this.liczbaDrzwi = liczbaDrzwi;
		this.liczbaMiejsc = liczbaMiejsc;
		this.pojemnoscBagaznikaWLitrach = pojemnoscBagaznikaWLitrach;
		this.zuzyciePaliwaNa100Km = zuzyciePaliwaNa100Km;
		
		
	}
	public Auta(int idauta, String marka, String model, String segment, String paliwo, String skrzynia_biegow,
			String numerRejestracyjny, String numer_VIN, String numerNadwozia, String numerSilnika, String rocznik, String kolor, String moc_silnika_KM,
			String naped_na_kola, String liczbaMiejsc, String liczbaDrzwi, String pojemnoscBagaznikaWLitrach, String zuzyciePaliwaNa100Km
			){
		this.idauta = idauta;
		this.marka=marka;
		this.model=model;
		this.segment = segment;
		this.skrzyniaBiegow = skrzynia_biegow;
		this.paliwo=paliwo;
		this.numerRejestracyjny=numerRejestracyjny;
		this.numer_VIN=numer_VIN;
		this.numerNadwozia = numerNadwozia;
		this.numerSilnika = numerSilnika;
		this.rocznik=rocznik;
		this.kolor = kolor;
		this.moc_silnika_KM = moc_silnika_KM;
		this.napedNaKola = naped_na_kola;
		this.liczbaMiejsc = liczbaMiejsc;
		this.liczbaDrzwi = liczbaDrzwi;
		this.pojemnoscBagaznikaWLitrach = pojemnoscBagaznikaWLitrach;
		this.zuzyciePaliwaNa100Km = zuzyciePaliwaNa100Km;
	}
	public Auta(int idauta, String marka, String model, String segment, String paliwo, String skrzynia_biegow,
			String numerRejestracyjny, String numer_VIN, String numerNadwozia, String numerSilnika, String rocznik, String kolor, String moc_silnika_KM,
			String naped_na_kola, String liczbaMiejsc, String liczbaDrzwi, String pojemnoscBagaznikaWLitrach, String zuzyciePaliwaNa100Km,
			Segment s, Kolor k, Marka m, AutoWyposazenie aw, Administrator a){
		this.idauta = idauta;
		this.marka=marka;
		this.model=model;
		this.segment = segment;
		this.skrzyniaBiegow = skrzynia_biegow;
		this.paliwo=paliwo;
		this.numerRejestracyjny=numerRejestracyjny;
		this.numer_VIN=numer_VIN;
		this.numerNadwozia = numerNadwozia;
		this.numerSilnika = numerSilnika;
		this.rocznik=rocznik;
		this.kolor = kolor;
		this.moc_silnika_KM = moc_silnika_KM;
		this.napedNaKola = naped_na_kola;
		this.liczbaMiejsc = liczbaMiejsc;
		this.liczbaDrzwi = liczbaDrzwi;
		this.pojemnoscBagaznikaWLitrach = pojemnoscBagaznikaWLitrach;
		this.zuzyciePaliwaNa100Km = zuzyciePaliwaNa100Km;
		this.k=k;
		this.m=m;
		this.s=s;
		this.a=a;
	}
	public int getIdauta() {
		return this.idauta;
	}

	public void setIdauta(int idauta) {
		this.idauta = idauta;
	}

	public String getKolor() {
		return this.kolor;
	}

	public void setKolor(String kolor) {
		this.kolor = kolor;
	}

	public String getLiczbaDrzwi() {
		return this.liczbaDrzwi;
	}

	public void setLiczbaDrzwi(String liczbaDrzwi) {
		this.liczbaDrzwi = liczbaDrzwi;
	}

	public String getLiczbaMiejsc() {
		return this.liczbaMiejsc;
	}

	public void setLiczbaMiejsc(String liczbaMiejsc) {
		this.liczbaMiejsc = liczbaMiejsc;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getMoc_silnika_KM() {
		return this.moc_silnika_KM;
	}

	public void setMoc_silnika_KM(String moc_silnika_KM) {
		this.moc_silnika_KM = moc_silnika_KM;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNapedNaKola() {
		return this.napedNaKola;
	}

	public void setNapedNaKola(String napedNaKola) {
		this.napedNaKola = napedNaKola;
	}

	public String getNumerNadwozia() {
		return this.numerNadwozia;
	}

	public void setNumerNadwozia(String numerNadwozia) {
		this.numerNadwozia = numerNadwozia;
	}

	public String getNumerRejestracyjny() {
		return this.numerRejestracyjny;
	}

	public void setNumerRejestracyjny(String numerRejestracyjny) {
		this.numerRejestracyjny = numerRejestracyjny;
	}

	public String getNumerSilnika() {
		return this.numerSilnika;
	}

	public void setNumerSilnika(String numerSilnika) {
		this.numerSilnika = numerSilnika;
	}

	public String getNumer_VIN() {
		return this.numer_VIN;
	}

	public void setNumer_VIN(String numer_VIN) {
		this.numer_VIN = numer_VIN;
	}

	public String getPaliwo() {
		return this.paliwo;
	}

	public void setPaliwo(String paliwo) {
		this.paliwo = paliwo;
	}

	public String getPojemnoscBagaznikaWLitrach() {
		return this.pojemnoscBagaznikaWLitrach;
	}

	public void setPojemnoscBagaznikaWLitrach(String pojemnoscBagaznikaWLitrach) {
		this.pojemnoscBagaznikaWLitrach = pojemnoscBagaznikaWLitrach;
	}

	public String getRocznik() {
		return this.rocznik;
	}

	public void setRocznik(String rocznik) {
		this.rocznik = rocznik;
	}

	public String getSegment() {
		return this.segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getSkrzyniaBiegow() {
		return this.skrzyniaBiegow;
	}

	public void setSkrzyniaBiegow(String skrzyniaBiegow) {
		this.skrzyniaBiegow = skrzyniaBiegow;
	}

	public String getZuzyciePaliwaNa100Km() {
		return this.zuzyciePaliwaNa100Km;
	}

	public void setZuzyciePaliwaNa100Km(String zuzyciePaliwaNa100Km) {
		this.zuzyciePaliwaNa100Km = zuzyciePaliwaNa100Km;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idsegment", nullable = false, insertable = false, updatable = false)
	public Segment getS() {
		return s;
	}
	public void setS(Segment s) {
		this.s = s;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idkolor", nullable = false, insertable = false, updatable = false)
	public Kolor getK() {
		return k;
	}
	public void setK(Kolor k) {
		this.k = k;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idmarka", nullable = false, insertable = false, updatable = false)
	public Marka getM() {
		return m;
	}
	public void setM(Marka m) {
		this.m = m;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idadministrator", nullable = false, insertable = false, updatable = false)
	public Administrator getA() {
		return a;
	}
	public void setA(Administrator a) {
		this.a = a;
	}

}