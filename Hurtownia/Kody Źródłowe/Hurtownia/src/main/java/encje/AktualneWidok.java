package encje;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the AKTUALNE_WIDOK database table.
 * 
 */
@Entity
@Table(name="AKTUALNE_WIDOK")
public class AktualneWidok implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Date dataZakonczenia;

	
	private Date dataZamowienia;

	
	private int id;

	
	private String status;
	
	private int id1;

	public AktualneWidok() {
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
	
	@Column(name="STATUS")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="ID1")
	public int getId1() {
		return this.id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

}