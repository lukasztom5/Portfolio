package p.lodz.pl.encje;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable

public class AutoWyposazeniePK implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int idauta;
	private int idwyposazenie;
	
	public AutoWyposazeniePK() {
		super();
	}
	public AutoWyposazeniePK(int idauta, int idwyposazenie) {
		this.idauta = idauta;
		this.idwyposazenie = idwyposazenie;
	} 
	@Column(name="idauta",nullable=false)
	public int getIdauta() {
		return idauta;
	}

	public void setIdauta(int idauta) {
		this.idauta = idauta;
	}
	@Column(name="idwyposazenie",nullable=false)
	public int getIdwyposazenie() {
		return idwyposazenie;
	}

	public void setIdwyposazenie(int idwyposazenie) {
		this.idwyposazenie = idwyposazenie;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idauta;
		result = prime * result + idwyposazenie;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoWyposazeniePK other = (AutoWyposazeniePK) obj;
		if (idauta != other.idauta)
			return false;
		if (idwyposazenie != other.idwyposazenie)
			return false;
		return true;
	}
}
