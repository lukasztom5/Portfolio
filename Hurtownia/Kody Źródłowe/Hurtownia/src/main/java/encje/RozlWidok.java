package encje;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="ROZL_WIDOK")
public class RozlWidok implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DATA_ROZLICZENIA")
	private String dataRozliczenia;

	@Column(name="DATA_ZATRUDNIENIA")
	private String dataZatrudnienia;

	@Column(name="DATA_ZWOLNIENIA")
	private String dataZwolnienia;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="IMIE")
	private String imie;
	@Column(name="KARA")
	private String kara;
	@Column(name="NAZWISKO")
	private String nazwisko;
	@Column(name="PENSJA")
	private String pensja;
	@Column(name="PREMIA")
	private String premia;

	@Column(name="RODZAJ_ZATRUDNIENIA")
	private String rodzajZatrudnienia;

	@Column(name="SZCZEGOLY_KARY")
	private String szczegolyKary;

	@Column(name="SZCZEGOLY_PREMII")
	private String szczegolyPremii;

	@Column(name="SZCZEGOLY_ZWOLNIENIA")
	private String szczegolyZwolnienia;

	private String wyplata;

	public RozlWidok() {
	}

	public String getDataRozliczenia() {
		return this.dataRozliczenia;
	}

	public void setDataRozliczenia(String dataRozliczenia) {
		this.dataRozliczenia = dataRozliczenia;
	}

	public String getDataZatrudnienia() {
		return this.dataZatrudnienia;
	}

	public void setDataZatrudnienia(String dataZatrudnienia) {
		this.dataZatrudnienia = dataZatrudnienia;
	}

	public String getDataZwolnienia() {
		return this.dataZwolnienia;
	}

	public void setDataZwolnienia(String dataZwolnienia) {
		this.dataZwolnienia = dataZwolnienia;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getKara() {
		return this.kara;
	}

	public void setKara(String kara) {
		this.kara = kara;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPensja() {
		return this.pensja;
	}

	public void setPensja(String pensja) {
		this.pensja = pensja;
	}

	public String getPremia() {
		return this.premia;
	}

	public void setPremia(String premia) {
		this.premia = premia;
	}

	public String getRodzajZatrudnienia() {
		return this.rodzajZatrudnienia;
	}

	public void setRodzajZatrudnienia(String rodzajZatrudnienia) {
		this.rodzajZatrudnienia = rodzajZatrudnienia;
	}

	public String getSzczegolyKary() {
		return this.szczegolyKary;
	}

	public void setSzczegolyKary(String szczegolyKary) {
		this.szczegolyKary = szczegolyKary;
	}

	public String getSzczegolyPremii() {
		return this.szczegolyPremii;
	}

	public void setSzczegolyPremii(String szczegolyPremii) {
		this.szczegolyPremii = szczegolyPremii;
	}

	public String getSzczegolyZwolnienia() {
		return this.szczegolyZwolnienia;
	}

	public void setSzczegolyZwolnienia(String szczegolyZwolnienia) {
		this.szczegolyZwolnienia = szczegolyZwolnienia;
	}

	public String getWyplata() {
		return this.wyplata;
	}

	public void setWyplata(String wyplata) {
		this.wyplata = wyplata;
	}

}