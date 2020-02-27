package p.lodz.pl.encje;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="segment")
@NamedQuery(name="Segment.findAll", query="SELECT s FROM Segment s")
public class Segment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idsegment")
	private int idsegment;
	@Column(name="cena_za_dobe")
	private int cenaZaDobe;
	@Column(name="rodzaj")
	private String rodzaj;

	public Segment() {
	}
	public Segment(int idsegment, String rodzaj,int cenaZaDobe){
		this.idsegment=idsegment;
		this.rodzaj=rodzaj;
		this.cenaZaDobe=cenaZaDobe;
	}
	public int getIdsegment() {
		return this.idsegment;
	}

	public void setIdsegment(int idsegment) {
		this.idsegment = idsegment;
	}

	public int getCenaZaDobe() {
		return this.cenaZaDobe;
	}

	public void setCenaZaDobe(int cenaZaDobe) {
		this.cenaZaDobe = cenaZaDobe;
	}

	public String getRodzaj() {
		return this.rodzaj;
	}

	public void setRodzaj(String rodzaj) {
		this.rodzaj = rodzaj;
	}

}