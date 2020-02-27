package encje;

import encje.Administrator;
import encje.Pracownik;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rozliczenie
 *
 */
@Entity
@Table(name = "ROZLICZENIE")
public class Rozliczenie implements Serializable {


	private Integer IDROZLICZENIE;
	private Administrator IDADMINISTRATOR;
	private Pracownik IDPRACOWNIK;
	private String Rozliczenie;
	private static final long serialVersionUID = 1L;

	public Rozliczenie() {
		super();
	}  
	public Rozliczenie(Integer idroz, Administrator ad, Pracownik p, String roz) {
		this.IDROZLICZENIE=idroz;
		this.IDADMINISTRATOR=ad;
		this.IDPRACOWNIK=p;
		this.Rozliczenie=roz;
	}
	@Id
	@Column(name = "IDROZLICZENIE", unique = true, nullable = false)
	public Integer getIDROZLICZENIE() {
		return this.IDROZLICZENIE;
	}

	public void setIDROZLICZENIE(Integer IDROZLICZENIE) {
		this.IDROZLICZENIE = IDROZLICZENIE;
	}   
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDADMINISTRATOR", nullable = false)
	public Administrator getIDADMINISTRATOR() {
		return this.IDADMINISTRATOR;
	}

	public void setIDADMINISTRATOR(Administrator IDADMINISTRATOR) {
		this.IDADMINISTRATOR = IDADMINISTRATOR;
	} 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDPRACOWNIK", nullable = false)
	public Pracownik getIDPRACOWNIK() {
		return this.IDPRACOWNIK;
	}

	public void setIDPRACOWNIK(Pracownik IDPRACOWNIK) {
		this.IDPRACOWNIK = IDPRACOWNIK;
	}   
	@Column(name="ROZLICZENIE")
	public String getRozliczenie() {
		return this.Rozliczenie;
	}

	public void setRozliczenie(String Rozliczenie) {
		this.Rozliczenie = Rozliczenie;
	}
   
}
