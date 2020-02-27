package p.lodz.pl.encje;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="wyposazenie")
@NamedQuery(name="Wyposazenie.findAll", query="SELECT w FROM Wyposazenie w")
public class Wyposazenie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idwyposazenie")
	private int idwyposazenie;

	@Column(name="cena_dzien")
	private double cenaDzien;
	@Column(name="dodatek")
	private String dodatek;

	public Wyposazenie() {
	}
	public Wyposazenie(int idwyposazenie, String dodatek,double cenaDzien){
		this.idwyposazenie=idwyposazenie;
		this.dodatek=dodatek;
		this.cenaDzien=cenaDzien;
	}
	public int getIdwyposazenie() {
		return this.idwyposazenie;
	}

	public void setIdwyposazenie(int idwyposazenie) {
		this.idwyposazenie = idwyposazenie;
	}

	public double getCenaDzien() {
		return this.cenaDzien;
	}

	public void setCenaDzien(double cenaDzien) {
		this.cenaDzien = cenaDzien;
	}

	public String getDodatek() {
		return this.dodatek;
	}

	public void setDodatek(String dodatek) {
		this.dodatek = dodatek;
	}

}