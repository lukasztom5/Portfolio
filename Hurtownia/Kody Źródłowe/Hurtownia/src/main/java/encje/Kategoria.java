package encje;

import encje.Urzadzenie;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Kategoria
 *
 */
@Entity
@Table(name = "KATEGORIA")
public class Kategoria implements Serializable {

	   
	
	private Integer IDKATEGORIA;
	private Urzadzenie IDURZADZENIE;
	private String NAZWA;
	private static final long serialVersionUID = 1L;

	public Kategoria() {
		super();
	} 
	public Kategoria(Integer idkat, Urzadzenie ad, String dane) {
		this.IDKATEGORIA=idkat;
		this.IDURZADZENIE=ad;
		this.NAZWA=dane;
	}
	@Id
	@Column(name = "IDKATEGORIA", unique = true, nullable = false)
	public Integer getIDKATEGORIA() {
		return this.IDKATEGORIA;
	}

	public void setIDKATEGORIA(Integer IDKATEGORIA) {
		this.IDKATEGORIA = IDKATEGORIA;
	}   
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDURZADZENIE", nullable = false)
	public Urzadzenie getIDURZADZENIE() {
		return this.IDURZADZENIE;
	}

	public void setIDURZADZENIE(Urzadzenie IDURZADZENIE) {
		this.IDURZADZENIE = IDURZADZENIE;
	}   
	@Column(name="NAZWA")
	public String getNAZWA() {
		return this.NAZWA;
	}

	public void setNAZWA(String NAZWA) {
		this.NAZWA = NAZWA;
	}
   
}
