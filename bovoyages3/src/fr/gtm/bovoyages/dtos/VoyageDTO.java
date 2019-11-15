package fr.gtm.bovoyages.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.gtm.bovoyages.entities.Voyage;
import fr.gtm.bovoyages.entities.Voyageur;

public class VoyageDTO implements Serializable{
	
	private long id;
	private String region;
	private String descriptif;
	private long fkClient;
	private long fk_dates_voyages;
	private List<Voyageur> participants=new ArrayList<Voyageur>();
	
	public VoyageDTO() {}
	
	public VoyageDTO(Voyage voyage) {
		super();
		this.id = voyage.getId();
		this.region = voyage.getRegion();
		this.descriptif = voyage.getDescriptif();
		this.fkClient = voyage.getFkClient();
//		this.participants = participants;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getDescriptif() {
		return descriptif;
	}


	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	
	public long getFkClient() {
		return fkClient;
	}


	public void setFkClient(long fkClient) {
		this.fkClient = fkClient;
	}

	public long getFk_dates_voyages() {
		return fk_dates_voyages;
	}

	public void setFk_dates_voyages(long fk_dates_voyages) {
		this.fk_dates_voyages = fk_dates_voyages;
	}

	public List<Voyageur> getParticipants() {
		return participants;
	}


	public void setParticipants(List<Voyageur> participants) {
		this.participants = participants;
	}

}
