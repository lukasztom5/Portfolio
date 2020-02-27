package p.lodz.pl.encje;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@Table(name="klient")
@NamedNativeQueries({
	@NamedNativeQuery(
			name = "kfindAll",
			query = "select * from klient k",
			resultClass = Klient.class)
})
public class Klient implements Serializable {

	private static final long serialVersionUID = -6851099032528029976L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name="idklient", unique = true, nullable = false, precision = 4, scale = 0)
	private int idklient;
	@Column(name="adres", length=100)
	private String adres;
	@Column(name="adres_mail", length=100)
	private String adresMail;
	@Column(name="haslo", length=100)
	private String haslo;
	@Column(name="imie", length=100)
	private String imie;
	@Column(name="login", length=100)
	private String login;
	@Column(name="miasto", length=100)
	private String miasto;
	@Column(name="nazwisko", length=100)
	private String nazwisko;
	@Column(name="pesel", length=11)
	private String pesel;
	@Column(name="telefon", length=9)
	private String telefon;

	public Klient() {
	}
	public Klient(int idklient, String imie, String nazwisko, String login, String haslo){
		this.idklient = idklient;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.login = login;
		this.haslo = haslo;
	}
	public Klient(int idklient, String imie, String nazwisko, String pesel, 
			String miasto, String adres, String adresMail, String telefon, String login, String haslo){
		this.idklient = idklient;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel=pesel;
		this.miasto = miasto;
		this.adres = adres;
		this.adresMail= adresMail;
		this.telefon = telefon;
		this.login = login;
		this.haslo = haslo;
	}
	public int getIdklient() {
		return this.idklient;
	}

	public void setIdklient(int idklient) {
		this.idklient = idklient;
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

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getPesel() {
		return this.pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}