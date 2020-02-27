package encje;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: KlientDane
 *
 */
@Entity
@Table(name = KlientDane.KLIENT_DANE)
public class KlientDane implements Serializable {


	static final String KLIENT_DANE = "KLIENT_DANE";
	private Integer idklient;
	private String kraj;
	private String miasto;
	private String nazwisko;
	private String imie;
	private String zaklad;
	private String adres_mail;
	private String adres;
	private String telefon;
	private String kod;
	
	private static final long serialVersionUID = 1L;

	public KlientDane() {
		super();
	} 
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getIdklient() {
		return this.idklient;
	}

	public void setIdklient(Integer idklient) {
		this.idklient = idklient;
	}   
	 @Column(name="KRAJ")
	public String getKraj() {
		return this.kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}   
	@Column(name="MIASTO")
	public String getMiasto() {
		return this.miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}   
	@Column(name="ZAKLAD")
	public String getZaklad() {
		return this.zaklad;
	}

	public void setZaklad(String zaklad) {
		this.zaklad=zaklad;
	}  
	@Column(name="NAZWISKO")
	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}  
	@Column(name="IMIE")
	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}  
	@Column(name="ADRES_MAIL")
	public String getAdres_mail() {
		return this.adres_mail;
	}

	public void setAdres_mail(String adres_mail) {
		this.adres_mail = adres_mail;
	}  
	@Column(name="ADRES")
	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
	@Column(name="TELEFON")
	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
   
	@Column(name="KOD")
	public String getKod() {
		return this.kod;
	}

	public void setKod(String Kod) {
		this.kod = Kod;
	}
	
}
