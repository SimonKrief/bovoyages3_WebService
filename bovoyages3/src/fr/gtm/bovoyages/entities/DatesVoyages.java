package fr.gtm.bovoyages.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dates_voyages")
public class DatesVoyages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_date_voyage")
	private long id;
	@Column(name = "date_depart")
	private Date dateDepart;
	@Column(name = "date_retour")
	private Date dateRetour;
	@Column(name = "prixHT")
	private float prixHT;
	@Column(name = "deleted")
	private int deleted;
	@Column(name = "nb_places")
	private int nbPlaces;
	@Column(name = "fk_destination")
	private long fkDestination;

public DatesVoyages() {}

	public DatesVoyages(Date dateDepart, Date dateRetour, float prixHT, int deleted, int nbPlaces,
			long fkDestination) {
		super();
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.prixHT = prixHT;
		this.deleted = deleted;
		this.nbPlaces = nbPlaces;
		this.fkDestination = fkDestination;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public long getFkDestination() {
		return fkDestination;
	}

	public void setFkDestination(long fkDestination) {
		this.fkDestination = fkDestination;
	}

}
