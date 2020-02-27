package encje;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
@Entity
@Table(name = "PRACOWNIK")
public class Pracownik implements Serializable {

	   
	
	private int IDPRACOWNIK;
	private Administrator IDADMINISTRATOR;
	private String UMOWA;
	private String LOGIN;
	private String HASLO;
	private static final long serialVersionUID = 1L;

	public Pracownik(int idprac, Administrator i,String dane, String login, String haslo) {
		this.IDPRACOWNIK=idprac;
		this.IDADMINISTRATOR=i;
		this.UMOWA=dane;
		this.LOGIN=login;
		this.HASLO=haslo;
	}  
	public Pracownik() {
		super();
	} 
	
	@Id
	@Column(name = "IDPRACOWNIK", unique = true, nullable = false)
	public int getIDPRACOWNIK() {
		return this.IDPRACOWNIK;
	}

	public void setIDPRACOWNIK(int IDPRACOWNIK) {
		this.IDPRACOWNIK = IDPRACOWNIK;
	}   
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDADMINISTRATOR", nullable = false)
	public Administrator getIDADMINISTRATOR() {
		return this.IDADMINISTRATOR;
	}

	public void setIDADMINISTRATOR(Administrator IDADMINISTRATOR) {
		this.IDADMINISTRATOR = IDADMINISTRATOR;
	}   
	@Column(name="UMOWA")
	public String getUMOWA() {
		return this.UMOWA;
	}

	public void setUMOWA(String UMOWA) {
		this.UMOWA = UMOWA;
	}  
	@Column(name="LOGIN")
	public String getLOGIN() {
		return this.LOGIN;
	}

	public void setLOGIN(String LOGIN) {
		this.LOGIN = LOGIN;
	}   
	@Column(name="HASLO")
	public String getHASLO() {
		return this.HASLO;
	}

	public void setHASLO(String HASLO) {
		this.HASLO = HASLO;
	}
   
}
