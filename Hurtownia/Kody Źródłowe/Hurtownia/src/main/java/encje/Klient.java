package encje;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Klient
 *
 */
@Entity
@Table(name = "KLIENT")
public class Klient implements Serializable {

	
	private int IDKLIENT;
	private String DANE;
	private String LOGIN;
	private String HASLO;
	private static final long serialVersionUID = 1L;

	public Klient() {
		super();
	}   
	public Klient(int IDKLIENT, String DANE, String LOGIN, String HASLO){
		this.IDKLIENT = IDKLIENT;
		this.DANE = DANE;
		this.LOGIN = LOGIN;
		this.HASLO = HASLO;
	}
	@Id   
	@Column(name = "IDKLIENT", unique = true, nullable = false)
	public int getIDKLIENT() {
		return this.IDKLIENT;
	}

	public void setIDKLIENT(int IDKLIENT) {
		this.IDKLIENT = IDKLIENT;
	}   
	 @Column(name="DANE")
	public String getDANE() {
		return this.DANE;
	}

	public void setDANE(String DANE) {
		this.DANE = DANE;
	}   
	@Column(name = "LOGIN", length = 50)
	public String getLOGIN() {
		return this.LOGIN;
	}

	public void setLOGIN(String LOGIN) {
		this.LOGIN = LOGIN;
	}   
	@Column(name = "HASLO", length = 50)
	public String getHASLO() {
		return this.HASLO;
	}

	public void setHASLO(String HASLO) {
		this.HASLO = HASLO;
	}
   
}
