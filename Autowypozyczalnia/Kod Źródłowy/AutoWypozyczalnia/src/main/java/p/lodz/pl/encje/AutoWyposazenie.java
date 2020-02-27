package p.lodz.pl.encje;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="auto_wyposazenie")
@NamedQuery(name="AutoWyposazenie.findAll", query="SELECT a FROM AutoWyposazenie a")
public class AutoWyposazenie implements Serializable {
	private static final long serialVersionUID = 1L;

	private AutoWyposazeniePK awpk;
    private Auta auto;
    private Wyposazenie wyposazenie;

	public AutoWyposazenie() {
	}
	public AutoWyposazenie(AutoWyposazeniePK awpk,Auta auto,Wyposazenie wyposazenie){
		this.auto=auto;
		this.wyposazenie=wyposazenie;
		this.awpk=awpk;
	}
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name="idauta",column=@Column(name="idauta",nullable=false,length=100)),
		@AttributeOverride(name="idwyposazenie",column=@Column(name="idwyposazenie",nullable=false,length=100))})
	public AutoWyposazeniePK getAwpk() {
		return this.awpk;
	}

	public void setAwpk(AutoWyposazeniePK awpk) {
		this.awpk = awpk;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idauta",nullable=false,insertable=false,updatable=false)
	public Auta getAuto() {
		return auto;
	}
	public void setAuto(Auta auto) {
		this.auto = auto;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idwyposazenie",nullable=false,insertable=false,updatable=false)
	public Wyposazenie getWyposazenie() {
		return wyposazenie;
	}
	public void setWyposazenie(Wyposazenie wyposazenie) {
		this.wyposazenie = wyposazenie;
	}
}