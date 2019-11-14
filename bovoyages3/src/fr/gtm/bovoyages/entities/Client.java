package fr.gtm.bovoyages.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="clients")
@NamedQueries({
	@NamedQuery(name = "Client.getClients", query = "SELECT c FROM Client c order by c.nom asc"), // requête JPA type SQL pour récupérer toutes les destinations
})
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_client")
	private long id;
	@Column(name = "nom")
	private String nom;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
