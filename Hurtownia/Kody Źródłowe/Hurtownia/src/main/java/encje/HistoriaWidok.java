package encje;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the HISTORIA_WIDOK database table.
 * 
 */
@Entity
@Table(name="HISTORIA_WIDOK")
public class HistoriaWidok implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private double cena;

	
	private Date dataZakonczenia;

	
	private Date dataZamowienia;

	
	private int id;
	
	private int ilosc;
	
	private String platnosc;

	
	private String status;
	
	private double suma;
	
	private String zaplata;

	public HistoriaWidok() {
	}
	@Column(name="CENA")
	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ZAKONCZENIA")
	public Date getDataZakonczenia() {
		return this.dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ZAMOWIENIA")
	public Date getDataZamowienia() {
		return this.dataZamowienia;
	}

	public void setDataZamowienia(Date dataZamowienia) {
		this.dataZamowienia = dataZamowienia;
	}
	@Id
	@Column(name="ID")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="ILOSC")
	public int getIlosc() {
		return this.ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}
	@Column(name="PLATNOSC")
	public String getPlatnosc() {
		return this.platnosc;
	}

	public void setPlatnosc(String platnosc) {
		this.platnosc = platnosc;
	}

	public String getStatus() {
		return this.status;
	}
	@Column(name="STATUS")
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="SUMA")
	public double getSuma() {
		return this.suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}
	@Column(name="ZAPLATA")
	public String getZaplata() {
		return this.zaplata;
	}

	public void setZaplata(String zaplata) {
		this.zaplata = zaplata;
	}

}