package fr.gtm.bovoyages.entities;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity                       // annotation indiquant à JPA que la destination est une entité
@Table(name = "destinations") // annotation indiquant à JPA le nom de la table dans la base de donnée dont on charge les données pour une instance
@NamedQueries({
		@NamedQuery(name = "Destination.getDestinations", query = "SELECT d FROM Destination d order by d.region asc"), // requête JPA type SQL pour récupérer toutes les destinations
//		@NamedQuery(name = "Destination.getDates", query = "SELECT d.dates FROM Destination d where d like:d")
})
public class Destination {
//	
	@Id                                                   //annotation signalant à JPA que l'attribut est la clé primaire de la table
	@GeneratedValue(strategy = GenerationType.IDENTITY)   //annotation permettant à JPA lors de la persistance de l'entité d'attribuer une clé primaire suivant une logique
	@Column(name = "pk_destination")                      //annoation signalant à JPA quelle colonne de la table contient les valeurs de la clé primaire
	private long id;
	@Column(name = "region")
	private String region;                                       // region où la destination mène 
	@Column(name = "description")
	private String description;                                  // description de la région où mène la destination
	@Column(name = "deleted")
	private int deleted;                                         // parametre indiquant si une destination n'est plus valide
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)  // annotation signalant à JPA que l'attribut est lié à une autre table et que les données n'en sont pas chargé lors du chargement de l'entité
	@JoinColumn(name="fk_destination")
	private List<Image> images=new ArrayList<Image>();           // liste d'image de la région où mène la destination
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="fk_destination")
	private List<DatesVoyages> dates=new ArrayList<DatesVoyages>(); // liste de dates de voyages pour la destinations

	public Destination() {}

	public Destination(String region, String description) {
		this.region = region;
		this.description = description;
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
