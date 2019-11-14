package fr.gtm.bovoyages.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import fr.gtm.bovoyages.entities.DatesVoyages;


public class DatesVoyagesDTO implements Serializable {

	private long id;
	private LocalDate  dateDepart;
	private LocalDate  dateRetour;
	private float prixHT;
	private int deleted;
	private int nbPlaces;
	private long fkDestination;
	private long promotion;
	
	public DatesVoyagesDTO() {}
	
	public DatesVoyagesDTO(DatesVoyages datesVoyages) {
		super();
		this.dateDepart = datesVoyages.getDateDepart();
		this.dateRetour = datesVoyages.getDateRetour();
		this.prixHT = datesVoyages.getPrixHT();
		this.deleted = datesVoyages.getDeleted();
		this.nbPlaces = datesVoyages.getNbPlaces();
		this.fkDestination = datesVoyages.getFkDestination();
		this.promotion = datesVoyages.getPromotion();
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalDate getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(LocalDate dateRetour) {
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

	public long getPromotion() {
		return promotion;
	}

	public void setPromotion(long promotion) {
		this.promotion = promotion;
	}

}