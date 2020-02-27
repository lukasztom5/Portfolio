package p.lodz.pl.encje;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="marka")
@NamedQuery(name="Marka.findAll", query="SELECT m FROM Marka m")
public class Marka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idmarka")
	private int idmarka;
	@Column(name="kraj")
	private String kraj;
	@Column(name="nazwa")
	private String nazwa;

	public Marka() {
	}
	public Marka(int idmarka, String nazwa,String kraj){
		this.idmarka=idmarka;
		this.nazwa=nazwa;
		this.kraj=kraj;
	}
	public int getIdmarka() {
		return this.idmarka;
	}

	public void setIdmarka(int idmarka) {
		this.idmarka = idmarka;
	}

	public String getKraj() {
		return this.kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}