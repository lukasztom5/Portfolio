package encje;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Urzadzenie
 *
 */
@Entity
@Table(name="URZADZENIE")
public class Urzadzenie implements Serializable {

	   
	
	private Integer Idurzadzenie;
	
	private String Nazwa;
	private static final long serialVersionUID = 1L;

	public Urzadzenie() {
		super();
	}   
	public Urzadzenie(Integer idurzadzenie, String dane) {
		this.Idurzadzenie=idurzadzenie;
		this.Nazwa=dane;
	}
	@Id
	@Column(name="IDURZADZENIE", unique = true, nullable = false)
	public Integer getIdurzadzenie() {
		return this.Idurzadzenie;
	}

	public void setIdurzadzenie(Integer Idurzadzenie) {
		this.Idurzadzenie = Idurzadzenie;
	}   
	@Column(name="NAZWA")
	public String getNazwa() {
		return this.Nazwa;
	}

	public void setNazwa(String Nazwa) {
		this.Nazwa = Nazwa;
	}
   
}
