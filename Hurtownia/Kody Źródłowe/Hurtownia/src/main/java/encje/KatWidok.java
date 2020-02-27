package encje;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KAT_WIDOK database table.
 * 
 */
@Entity
@Table(name="KAT_WIDOK")
public class KatWidok implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;
	@Column(name="NAZWA")
	private String nazwa;

	public KatWidok() {
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