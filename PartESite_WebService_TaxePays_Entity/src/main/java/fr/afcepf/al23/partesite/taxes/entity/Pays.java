package fr.afcepf.al23.partesite.taxes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="taxes_pays")
public class Pays implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer code;
	private String alpha2;
	private String alpha3;
	@Column(name="nom_fr_fr")
	private String nomFrFr;
	@Column(name="nom_en_gb")
	private String nomEnGb;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getAlpha2() {
		return alpha2;
	}
	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}
	public String getAlpha3() {
		return alpha3;
	}
	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}
	public String getNomFrFr() {
		return nomFrFr;
	}
	public void setNomFrFr(String nomFrFr) {
		this.nomFrFr = nomFrFr;
	}
	public String getNomEnGb() {
		return nomEnGb;
	}
	public void setNomEnGb(String nomEnGb) {
		this.nomEnGb = nomEnGb;
	}
	
}
