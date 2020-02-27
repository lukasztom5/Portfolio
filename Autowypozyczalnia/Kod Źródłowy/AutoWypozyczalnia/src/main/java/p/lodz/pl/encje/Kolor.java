package p.lodz.pl.encje;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name="kolor")
@NamedQuery(name="Kolor.findAll", query="SELECT k FROM Kolor k")
public class Kolor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idkolor")
	private int idkolor;
	@Column(name="kolor_nadwozia")
	private String kolorNadwozia;

	public Kolor() {
	}
	public Kolor(int idkolor, String kolorNadwozia){
		this.idkolor=idkolor;
		this.kolorNadwozia=kolorNadwozia;
	}
	public int getIdkolor() {
		return this.idkolor;
	}

	public void setIdkolor(int idkolor) {
		this.idkolor = idkolor;
	}

	public String getKolorNadwozia() {
		return this.kolorNadwozia;
	}

	public void setKolorNadwozia(String kolorNadwozia) {
		this.kolorNadwozia = kolorNadwozia;
	}

}