package encje;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the URZADZENIE_DANE database table.
 * 
 */
@Entity
@Table(name="URZADZENIE_DANE")
public class UrzadzenieDane implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="NAZWA")
	private String nazwa;

	public UrzadzenieDane() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}