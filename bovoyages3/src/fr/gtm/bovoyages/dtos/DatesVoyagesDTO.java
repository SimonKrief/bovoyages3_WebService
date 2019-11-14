package fr.gtm.bovoyages.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import fr.gtm.bovoyages.entities.DatesVoyages;


public class DatesVoyagesDTO implements Serializable {

	private long id;
	private Date  dateDepart;
	private Date  dateRetour;
	private float prixHT;
	private int deleted;
	private int nbPlaces;
	private long fkDestination;
	
	public DatesVoyagesDTO() {}
	
	public DatesVoyagesDTO(DatesVoyages datesVoyages) {
		super();
		this.dateDepart = datesVoyages.getDateDepart();
		this.dateRetour = datesVoyages.getDateRetour();
		this.prixHT = datesVoyages.getPrixHT();
		this.deleted = datesVoyages.getDeleted();
		this.nbPlaces = datesVoyages.getNbPlaces();
		this.fkDestination = datesVoyages.getFkDestination();
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
