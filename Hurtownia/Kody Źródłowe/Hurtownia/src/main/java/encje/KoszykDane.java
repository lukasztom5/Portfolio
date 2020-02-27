package encje;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the KOSZYK_DANE database table.
 * 
 */
@Entity
@Table(name="KOSZYK_DANE")
public class KoszykDane implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cena;

	private Integer id;

	private String liczba;

	private String produkt;

	public KoszykDane() {
	}

	public String getCena() {
		return this.cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="LICZBA")
	public String getLiczba() {
		return this.liczba;
	}

	public void setLiczba(String liczba) {
		this.liczba = liczba;
	}
	@Column(name="PRODUKT")
	public String getProdukt() {
		return this.produkt;
	}

	public void setProdukt(String produkt) {
		this.produkt = produkt;
	}

}