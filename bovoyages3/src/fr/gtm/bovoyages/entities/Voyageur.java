package fr.gtm.bovoyages.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="voyageurs")
public class Voyageur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_voyageur")
private long id;
	@Column(name = "civilite")
private String civilite;
	@Column(name = "prenom")
private String prenom;
	@Column(name = "nom")
private String nom;
	@Column(name = "date_naissance")
private LocalDate dateNaissance;
	
	public Voyageur() {}

	public Voyageur(String civilite, String prenom, String nom, LocalDate dateNaissance) {
		super();
		this.civilite = civilite;
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
}
