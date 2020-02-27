package p.lodz.pl.encje;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="aktualne_wypozyczenie")
public class AktualneWypozyczenie implements Serializable {
	private static final long serialVersionUID = 8746325773586343491L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name="idaktualne_wypozyczenie", unique = true, nullable = false, precision = 4, scale = 0)
	private int idaktualne_wypozyczenie;

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
	
	@Column(name="data_rezerwacja", length=100)
	private Date dataRezerwacja;

	@Column(name="data_zwrotu", length=100)
	private Date dataZwrotu;
	
	@Column(name="idauta")
	private Auta auta;
	
	@Column(name="idadministrator")
	private Administrator administrator;
	
	@Column(name="idklient")
	private Klient klient;
	

	public AktualneWypozyczenie() {
	}
	public AktualneWypozyczenie(int idaktualne_wypozyczenie, String marka, String model, String imie, String 
			nazwisko, Date dataRezerwacja, Date dataZwrotu){
			this.idaktualne_wypozyczenie=idaktualne_wypozyczenie;
			this.marka=marka;
			this.model=model;
			this.imie=imie;
			this.nazwisko=nazwisko;
			this.dataRezerwacja=dataRezerwacja;
			this.dataZwrotu=dataZwrotu;
		}
	public AktualneWypozyczenie(int idaktualne_wypozyczenie, int klientid, int autoid, String marka, String model, String imie, String 
			nazwisko, Date dataRezerwacja, Date dataZwrotu){
			this.idaktualne_wypozyczenie=idaktualne_wypozyczenie;
			this.marka=marka;
			this.model=model;
			this.imie=imie;
			this.nazwisko=nazwisko;
			this.dataRezerwacja=dataRezerwacja;
			this.dataZwrotu=dataZwrotu;
			this.autoid=autoid;
			this.klientid=klientid;
		}
	public int getIdaktualneWypozyczenie() {
		return this.idaktualne_wypozyczenie;
	}

	public void setIdaktualneWypozyczenie(int idaktualneWypozyczenie) {
		this.idaktualne_wypozyczenie = idaktualneWypozyczenie;
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
	
	
	
	public Object getDataRezerwacja() {
		return this.dataRezerwacja;
	}

	public void setDataRezerwacja(Date dataRezerwacja) {
		this.dataRezerwacja = dataRezerwacja;
	}
	public Object getDataZwrotu() {
		return this.dataZwrotu;
	}

	public void setDataZwrotu(Date dataZwrotu) {
		this.dataZwrotu = dataZwrotu;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idauta", nullable = false, insertable = false, updatable = false)
	public Auta getAuta() {
		return auta;
	}
	public void setAuta(Auta auta) {
		this.auta = auta;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idadministrator", nullable = false, insertable = false, updatable = false)
	public Administrator administrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idklient", nullable = false, insertable = false, updatable = false)
	public Klient getKlient() {
		return klient;
	}
	public void setKlient(Klient klient) {
		this.klient = klient;
	}
	
	
}