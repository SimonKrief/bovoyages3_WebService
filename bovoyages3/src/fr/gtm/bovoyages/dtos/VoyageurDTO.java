package fr.gtm.bovoyages.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.gtm.bovoyages.entities.Voyageur;

public class VoyageurDTO implements Serializable{
	
	private long id;
	private String civilite;
	private String prenom;
	private String nom;
	private Date dateNaissance;
	
	public VoyageurDTO() {}

	public VoyageurDTO(Voyageur voyageur) {
		super();
		this.civilite = voyageur.getCivilite();
		this.prenom = voyageur.getPrenom();
		this.nom = voyageur.getNom();
//		this.dateNaissance = dateNaissance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
}
