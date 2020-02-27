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
@Table(name = "HISTORIA_ZAMOWIENIA")
public class HistoriaZamowienia implements Serializable {

	   
	private Integer IDHISTORIAZAMOWIENIA;
	private Klient IDKLIENT;
	private Pracownik IDPRACOWNIK;
	private Czesc IDCZESC;
	private String POTWIERDZENIE;
	private static final long serialVersionUID = 1L;

	public HistoriaZamowienia() {
		super();
	}   
	public HistoriaZamowienia(int idhis, Klient k, Pracownik p, Czesc c, String potwierdzenie1) {
		this.IDHISTORIAZAMOWIENIA=idhis;
		this.IDKLIENT=k;
		this.IDPRACOWNIK=p;
		this.IDCZESC=c;
		this.POTWIERDZENIE=potwierdzenie1;
	}
	@Id
	@Column(name = "IDHISTORIA", unique = true, nullable = false)
	public Integer getIDHISTORIAZAMOWIENIA() {
		return this.IDHISTORIAZAMOWIENIA;
	}

	public void setIDHISTORIAZAMOWIENIA(Integer IDHISTORIAZAMOWIENIA) {
		this.IDHISTORIAZAMOWIENIA = IDHISTORIAZAMOWIENIA;
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
