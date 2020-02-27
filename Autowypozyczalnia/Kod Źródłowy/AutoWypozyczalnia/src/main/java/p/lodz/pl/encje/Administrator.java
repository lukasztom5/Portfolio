package p.lodz.pl.encje;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
@Entity
@Table(name="administrator")
@NamedNativeQueries({
	@NamedNativeQuery(
			name = "findById",
			query = "select * from administrator a where a.idadministrator = :idad",
			resultClass = Administrator.class)
})
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idadministrator")
	private int idadministrator;
	@Column(name="adres")
	private String adres;
	@Column(name="haslo")
	private String haslo;
	@Column(name="imie")
	private String imie;
	@Column(name="login")
	private String login;
	@Column(name="miasto")
	private String miasto;
	@Column(name="nazwisko")
	private String nazwisko;
	@Column(name="idaktualne_wypozyczenie")
	private AktualneWypozyczenie aw;
	@Column(name="idhistoria_wypozyczenia")
	private HistoriaWypozyczenia hw;

	public Administrator() {
	}
	public Administrator(int idadministrator,String login, String haslo){
		this.idadministrator = idadministrator;
		this.login = login;
		this.haslo = haslo;
		}
		public Administrator(int idadministrator, String imie, String nazwisko, String login, String haslo
				, AktualneWypozyczenie aw,HistoriaWypozyczenia hw){
			this.idadministrator = idadministrator;
			this.imie = imie;
			this.nazwisko = nazwisko;
			this.login = login;
			this.haslo = haslo;
			this.aw=aw;
			this.hw=hw;
			
		}
	public int getIdadministrator() {
		return this.idadministrator;
	}

	public void setIdadministrator(int idadministrator) {
		this.idadministrator = idadministrator;
	}

	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idaktualne_wypozyczenie", nullable = false)
	public AktualneWypozyczenie getAw() {
		return aw;
	}
	public void setAw(AktualneWypozyczenie aw) {
		this.aw = aw;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idhistoria_wypozyczenia", nullable = false)
	public HistoriaWypozyczenia getHw() {
		return hw;
	}
	public void setHw(HistoriaWypozyczenia hw) {
		this.hw = hw;
	}
}