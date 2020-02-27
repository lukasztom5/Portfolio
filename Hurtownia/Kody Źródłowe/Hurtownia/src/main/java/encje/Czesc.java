package encje;

import encje.Kategoria;
import encje.Model;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Czesc
 *
 */
@Entity
@Table(name = "CZESC")
public class Czesc implements Serializable {

	   

	private Integer IDCZESC;
	private Model IDMODEL;
	private Kategoria IDKATEGORIA;
	private String DANE;
	private static final long serialVersionUID = 1L;

	public Czesc() {
		super();
	}   
	public Czesc(Integer idcz, Kategoria ad, Model ad1, String dane) {
		this.IDCZESC=idcz;
		this.IDKATEGORIA=ad;
		this.IDMODEL=ad1;
		this.DANE=dane;
	}
	@Id
	@Column(name = "IDCZESC", unique = true, nullable = false)
	public Integer getIDCZESC() {
		return this.IDCZESC;
	}

	public void setIDCZESC(Integer IDCZESC) {
		this.IDCZESC = IDCZESC;
	}   
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDMODEL", nullable = false)
	public Model getIDMODEL() {
		return this.IDMODEL;
	}

	public void setIDMODEL(Model IDMODEL) {
		this.IDMODEL = IDMODEL;
	}   
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDKATEGORIA", nullable = false)
	public Kategoria getIDKATEGORIA() {
		return this.IDKATEGORIA;
	}

	public void setIDKATEGORIA(Kategoria IDKATEGORIA) {
		this.IDKATEGORIA = IDKATEGORIA;
	}   
	@Column(name="DANE")
	public String getDANE() {
		return this.DANE;
	}

	public void setDANE(String DANE) {
		this.DANE = DANE;
	}
   
}
