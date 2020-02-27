package encje;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name=AdminDane.ADMIN_DANE)
public class AdminDane implements Serializable {
	
	static final String ADMIN_DANE = "ADMIN_DANE";
	private static final long serialVersionUID = 1L;

	private String adres;

	private String adresMail;


	private int id;

	private String imie;

	private String kraj;

	private String miasto;

	private String nazwisko;

	private String telefon;

	public AdminDane() {
	}
	@Column(name="ADRES")
	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
	@Column(name="ADRES_MAIL")
	public String getAdresMail() {
		return this.adresMail;
	}

	public void setAdresMail(String adresMail) {
		this.adresMail = adresMail;
	}
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="IMIE")
	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
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
	@Column(name="NAZWISKO")
	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	@Column(name="TELEFON")
	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}