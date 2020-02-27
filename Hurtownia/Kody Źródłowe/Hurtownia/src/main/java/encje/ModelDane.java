package encje;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MODEL_DANE database table.
 * 
 */
@Entity
@Table(name="MODEL_DANE")
public class ModelDane implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="FIRMA")
	private String firma;

	@Id
	@Column(name="ID")
	private int id;
	@Column(name="LINK")
	private String link;
	@Column(name="MODEL")
	private String model;

	public ModelDane() {
	}

	public String getFirma() {
		return this.firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}