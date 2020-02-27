package encje;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CZESC_WIDOK database table.
 * 
 */
@Entity
@Table(name="CZESC_WIDOK")
public class CzescWidok implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="CENA")
	private double cena;

	@Id
	@Column(name="ID")
	private int id;
	@Column(name="ILOSC")
	private int ilosc;
	@Column(name="NAZWA")
	private String nazwa;
	@Column(name="OBRAZ")
	private String obraz;

	public CzescWidok() {
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIlosc() {
		return this.ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getObraz() {
		return this.obraz;
	}

	public void setObraz(String obraz) {
		this.obraz = obraz;
	}

}