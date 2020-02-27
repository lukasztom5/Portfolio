package encje;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

/**
 * Entity implementation class for Entity: Administrator
 *
 */
@NamedNativeQueries({
	@NamedNativeQuery(
			name = "findCustomerByCustomerId",
			query = "select * from ADMINISTRATOR c where c.IDADMINISTRATOR = :aId",
			resultClass = Administrator.class)
})
@Entity
@Table(name = "ADMINISTRATOR")
public class Administrator implements Serializable {

	   
	
	private int IDADMINISTRATOR;
	private String DANE;
	private String LOGIN;
	private String HASLO;
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "IDADMINISTRATOR", unique = true, nullable = false)
	public int getIDADMINISTRATOR() {
		return this.IDADMINISTRATOR;
	}

	public void setIDADMINISTRATOR(int IDADMINISTRATOR) {
		this.IDADMINISTRATOR = IDADMINISTRATOR;
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
