package fr.afcepf.al23.partesite.taxes.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="taxes_frais")
public class Frais implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="pays_origine_id",referencedColumnName="id")
	private Pays paysOrigine;
	@ManyToOne
	@JoinColumn(name="pays_destination_id",referencedColumnName="id")
	private Pays paysDestination;
	private Integer taxes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pays getPaysOrigine() {
		return paysOrigine;
	}
	public void setPaysOrigine(Pays paysOrigine) {
		this.paysOrigine = paysOrigine;
	}
	public Pays getPaysDestination() {
		return paysDestination;
	}
	public void setPaysDestination(Pays paysDestination) {
		this.paysDestination = paysDestination;
	}
	public Integer getTaxes() {
		return taxes;
	}
	public void setTaxes(Integer taxes) {
		this.taxes = taxes;
	}
	
}
