package fr.gtm.bovoyages.entities;

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

import fr.gtm.bovoyages.dtos.VoyageDTO;

@Entity
@Table(name="voyages")
@NamedQueries({
	@NamedQuery(name = "Voyage.getVoyages", query = "SELECT v FROM Voyage v order by v.region asc"), // requête JPA type SQL pour récupérer toutes les destinations
//	@NamedQuery(name = "Destination.getDates", query = "SELECT d.dates FROM Destination d where d like:d")
})
public class Voyage implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_voyage")
	private long id;
	@Column(name = "region")
	private String region;
	@Column(name = "descriptif")
	private String descriptif;
	@Column(name = "fk_client")
	private long fkClient;
	@Column(name = "fk_dates_voyages")
	private long fk_dates_voyages;
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="voyages_voyageurs",
	joinColumns = @JoinColumn(name="fk_voyage"),
	inverseJoinColumns = @JoinColumn(name="fk_voyageur"))
	private List<Voyageur> participants=new ArrayList<Voyageur>();
	
	public Voyage() {}
	
	public Voyage(VoyageDTO voyageDTO) {
		this.region = voyageDTO.getRegion();
		this.descriptif = voyageDTO.getDescriptif();
		this.fkClient = voyageDTO.getFkClient();
		this.participants = voyageDTO.getParticipants();
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
