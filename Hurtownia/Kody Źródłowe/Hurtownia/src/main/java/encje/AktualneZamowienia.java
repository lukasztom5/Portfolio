package encje;

import encje.Czesc;
import encje.Klient;
import encje.Pracownik;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AktualneZamowienia
 *
 */
@Entity
@Table(name = "AKTUALNE_ZAMOWIENIA")
public class AktualneZamowienia implements Serializable {

	   
	private Integer IDAKTUALNEZAMOWIENIE;
	private Klient IDKLIENT;
	private Pracownik IDPRACOWNIK;
	private Czesc IDCZESC;
	private String POTWIERDZENIE;
	private static final long serialVersionUID = 1L;

	public AktualneZamowienia() {
		super();
	}   
	public AktualneZamowienia(int idakt, Klient k, Pracownik p, Czesc c,String potwierdzenie2) {
		this.IDAKTUALNEZAMOWIENIE=idakt;
		this.IDKLIENT=k;
		this.IDPRACOWNIK=p;
		this.IDCZESC=c;
		this.POTWIERDZENIE=potwierdzenie2;
	}
	@Id
	@Column(name = "IDAKTUALNE", unique = true, nullable = false)
	public Integer getIDAKTUALNEZAMOWIENIE() {
		return this.IDAKTUALNEZAMOWIENIE;
	}

	public void setIDAKTUALNEZAMOWIENIE(Integer IDAKTUALNEZAMOWIENIE) {
		this.IDAKTUALNEZAMOWIENIE = IDAKTUALNEZAMOWIENIE;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDKLIENT", nullable = false)
	public Klient getIDKLIENT() {
		return this.IDKLIENT;
	}

	public void setIDKLIENT(Klient IDKLIENT) {
		this.IDKLIENT = IDKLIENT;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDPRACOWNIK", nullable = false)
	public Pracownik getIDPRACOWNIK() {
		return this.IDPRACOWNIK;
	}

	public void setIDPRACOWNIK(Pracownik IDPRACOWNIK) {
		this.IDPRACOWNIK = IDPRACOWNIK;
	}  
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDCZESC", nullable = false)
	public Czesc getIDCZESC() {
		return this.IDCZESC;
	}

	public void setIDCZESC(Czesc IDCZESC) {
		this.IDCZESC = IDCZESC;
	}  
	@Column(name="POTWIERDZENIE")
	public String getPOTWIERDZENIE() {
		return this.POTWIERDZENIE;
	}

	public void setPOTWIERDZENIE(String POTWIERDZENIE) {
		this.POTWIERDZENIE = POTWIERDZENIE;
	}

   
}
