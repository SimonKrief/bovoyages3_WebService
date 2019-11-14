package fr.gtm.bovoyages.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.gtm.bovoyages.entities.DatesVoyages;
import fr.gtm.bovoyages.entities.Destination;
import fr.gtm.bovoyages.entities.Image;

public class DestinationDTO implements Serializable{

	private long id;
	private String region;
	private String description;
	private int deleted;
	private List<Image> images=new ArrayList<Image>();
	private List<DatesVoyages> dates=new ArrayList<DatesVoyages>();

	public DestinationDTO() {
	}

	public DestinationDTO(String region, String description) {
		this.region = region;
		this.description = description;
	}
	
	

	public DestinationDTO(Destination destination) {
		this.id = destination.getId();
		this.region = destination.getRegion();
		this.description = destination.getDescription();
		this.deleted = destination.getDeleted();
//		this.images = destination.getImage();
//		this.dates = destination.getDates();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public List<Image> getImage() {
		return images;
	}

	public void setImage(List<Image> image) {
		this.images = image;
	}

	public List<DatesVoyages> getDates() {
		return dates;
	}

	public void setDates(List<DatesVoyages> dates) {
		this.dates = dates;
	}

}
