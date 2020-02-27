package encje;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PRAC_DANE database table.
 * 
 */
@Entity
@Table(name="PRAC_DANE")
public class PracDane implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="ADRES")
	private String adres;

	@Column(name="ADRES_MAIL")
	private String adresMail;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ZAKONCZENIA")
	private Date dataZakonczenia;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ZATRUDNIENIA")
	private Date dataZatrudnienia;
	@Column(name="KOD")
	private String kod;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="IMIE")
	private String imie;
	@Column(name="KRAJ")
	private String kraj;
	@Column(name="MIASTO")
	private String miasto;
	@Column(name="NAZWISKO")
	private String nazwisko;

	@Column(name="NUMER_KONTA")
	private String numerKonta;
	@Column(name="PENSJA")
	private String pensja;
	@Column(name="TELEFON")
	private String telefon;

	@Column(name="TELEFON_SLUZBOWY")
	private String telefonSlu¿bowy;

	public PracDane() {
	}

	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getAdresMail() {
		return this.adresMail;
	}

	public void setAdresMail(String adresMail) {
		this.adresMail = adresMail;
	}

	public Date getDataZakonczenia() {
		return this.dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}

	public Date getDataZatrudnienia() {
		return this.dataZatrudnienia;
	}

	public void setDataZatrudnienia(Date dataZatrudnienia) {
		this.dataZatrudnienia = dataZatrudnienia;
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

	public String getKraj() {
		return this.kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

	public String getMiasto() {
		return this.miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNumerKonta() {
		return this.numerKonta;
	}

	public void setNumerKonta(String numerKonta) {
		this.numerKonta = numerKonta;
	}

	public String getPensja() {
		return this.pensja;
	}

	public void setPensja(String pensja) {
		this.pensja = pensja;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getTelefonSlu¿bowy() {
		return this.telefonSlu¿bowy;
	}

	public void setTelefonSlu¿bowy(String telefonSlu¿bowy) {
		this.telefonSlu¿bowy = telefonSlu¿bowy;
	}
	public String getKod() {
		return this.kod;
	}

	public void setKod(String kod) {
		this.kod=kod;
	}
}