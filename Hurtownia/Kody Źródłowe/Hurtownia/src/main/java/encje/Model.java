package encje;

import encje.Urzadzenie;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Model
 *
 */
@Entity
@Table(name = "MODEL")
public class Model implements Serializable {

	private Integer IDMODEL;
	private Urzadzenie IDURZADZENIE;
	private String NAZWA;
	private static final long serialVersionUID = 1L;

	public Model() {
		super();
	}   
	public Model(Integer idmodel,Urzadzenie u,String dane) {
		this.IDMODEL=idmodel;
		this.IDURZADZENIE=u;
		this.NAZWA=dane;
	}  
	
	@Id
	@Column(name = "IDMODEL", unique = true, nullable = false)
	public Integer getIDMODEL() {
		return this.IDMODEL;
	}

	public void setIDMODEL(Integer IDMODEL) {
		this.IDMODEL = IDMODEL;
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
