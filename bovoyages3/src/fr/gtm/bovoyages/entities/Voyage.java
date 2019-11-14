package fr.gtm.bovoyages.entities;


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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="voyages")
public class Voyage {
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
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="voyages_voyageurs",
	joinColumns = @JoinColumn(name="fk_voyage"),
	inverseJoinColumns = @JoinColumn(name="fk_voyageur"))
	private List<Voyageur> participants=new ArrayList<Voyageur>();

	
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


	public List<Voyageur> getParticipants() {
		return participants;
	}


	public void setParticipants(List<Voyageur> participants) {
		this.participants = participants;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
