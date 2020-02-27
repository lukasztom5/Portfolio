package encje;

import encje.Czesc;
import encje.Klient;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Koszyk
 *
 */
@Entity
@Table(name = "KOSZYK")
public class Koszyk implements Serializable {
   
	
	private Integer idkoszyk;
	private Czesc idczesc;
	private Klient idklient;
	private String zakupy;
	private static final long serialVersionUID = 1L;

	public Koszyk() {
		super();
	}   
	public Koszyk(Integer idkosz, Klient kd, Czesc c, String dane) {
		this.idkoszyk=idkosz;
		this.idczesc=c;
		this.idklient=kd;
		this.zakupy=dane;
	}
	@Id
	@Column(name = "IDZAKUP", unique = true, nullable = false)
	public Integer getIdkoszyk() {
		return this.idkoszyk;
	}

	public void setIdkoszyk(Integer idkoszyk) {
		this.idkoszyk = idkoszyk;
	} 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDCZESC", nullable = false)
	public Czesc getIdczesc() {
		return this.idczesc;
	}

	public void setIdczesc(Czesc idczesc) {
		this.idczesc = idczesc;
	} 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDKLIENT", nullable = false)
	public Klient getIdklient() {
		return this.idklient;
	}

	public void setIdklient(Klient idklient) {
		this.idklient = idklient;
	}   
	public String getZakupy() {
		return this.zakupy;
	}
	@Column(name="ZAKUPY")
	public void setZakupy(String zakupy) {
		this.zakupy = zakupy;
	}
   
}
