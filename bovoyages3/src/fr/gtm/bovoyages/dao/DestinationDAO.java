package fr.gtm.bovoyages.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import fr.gtm.bovoyages.dtos.DestinationDTO;
import fr.gtm.bovoyages.entities.Client;
import fr.gtm.bovoyages.entities.DatesVoyages;
import fr.gtm.bovoyages.entities.Destination;
import fr.gtm.bovoyages.entities.Image;
import fr.gtm.bovoyages.entities.Voyage;
import fr.gtm.bovoyages.entities.Voyageur;

@Singleton
public class DestinationDAO{

	@PersistenceContext(name="bovoyages") private EntityManager em;
//	@EJB private DatesVoyagesDAO datesVoyagesDAO;
	
//	public DestinationDAO() {}
//	
//	public void create(Destination destination) {
//		em.persist(destination);
//	}
//	
//	public void delete(long id) {
//		em.remove(em.find(Destination.class, id));
//	}
//	
//	public void update(Destination destination) {
//		em.merge(destination);
//	}
//
//	public Destination getDestinationById(long id) {
//		return em.find(Destination.class, id);
//	}

	public List<Destination> getDestinations() {
		return em.createNamedQuery("Destination.getDestinations", Destination.class).getResultList();
	}
	
	public List<Voyage> addVoyage(Voyage voyage) {
		em.persist(voyage);
	return em.createNamedQuery("Voyage.getVoyages", Voyage.class).getResultList();
}
	
	public Voyage updateVoyage(Voyage voyage) {
		em.merge(voyage);
	return em.find(Voyage.class, voyage.getId());
}
	
	public List<Client> addClient(Client client) {
		em.persist(client);
	return em.createNamedQuery("Client.getClients", Client.class).getResultList();
}
	
	public Voyage addClientVoyage(Client client, String id) {
		Voyage voyage = em.find(Voyage.class, Long.valueOf(id));
		voyage.setFkClient(client.getId());
		this.updateVoyage(voyage);
	return em.find(Voyage.class, Long.valueOf(id));
}
	
	public List<Voyageur> addVoyageurAVoyage(Voyageur[] voyageurs, String id) {
		Voyage voyage = em.find(Voyage.class, Long.valueOf(id));
		DatesVoyages datesVoyage = em.find(DatesVoyages.class, voyage.getFk_dates_voyages());
		long nbPlaces = datesVoyage.getNbPlaces();
		if(nbPlaces - voyageurs.length >= 0 ) {
			datesVoyage.setNbPlaces((int)(nbPlaces - voyageurs.length));
			em.persist(datesVoyage);
			for(Voyageur voyageur : voyageurs) {
				em.persist(voyageur);
				}
			List<Voyageur> voyageursList = new ArrayList<Voyageur>();
			for(Voyageur voyageur : voyage.getParticipants()) {
				voyageursList.add(voyageur);
				}
			for(Voyageur voyageur : voyageurs) {
				voyageursList.add(voyageur);
				}
			voyage.setParticipants(voyageursList);
			this.updateVoyage(voyage);
			voyage = em.find(Voyage.class, Long.valueOf(id));
			voyageursList = new ArrayList<Voyageur>();
			for(Voyageur voyageur : voyage.getParticipants()) {
				voyageursList.add(voyageur);
				}
			
			return voyageursList;
		}
		else return new ArrayList<Voyageur>();
}
	
	public List<DatesVoyages> getDestinationDates(String id) {
		Destination d=em.find(Destination.class, Long.valueOf(id));
		List<DatesVoyages> dates=new ArrayList<DatesVoyages>();
		for(DatesVoyages date:d.getDates()) {
			if(date.getDeleted() == 0) {
				dates.add(date);
			}
		}
		return dates;
	}
	
	public List<DestinationDTO> getDestinationsDatesPromotion() {
		List<DatesVoyages> datesVoyages = new ArrayList<DatesVoyages>();
		List<DestinationDTO> destinationsPromotion = new ArrayList<DestinationDTO>();
		List<Destination> destinations = getDestinations();
		DestinationDTO destinationDTO;
		for (Destination d : destinations) {
			destinationDTO = new DestinationDTO(d);
			for (DatesVoyages date : d.getDates()) {
				if (date.getPromotion() != 0) {
					datesVoyages.add(date);
				}			
			}
			if (!datesVoyages.isEmpty()) {

				destinationDTO.setDates(datesVoyages);
				destinationsPromotion.add(destinationDTO);
			}
			datesVoyages = new ArrayList<DatesVoyages>();
		}
		return destinationsPromotion;
	}
	
//	public Destination addDestinationDate(long destinationID, DatesVoyages newDate) {
//		Destination d=em.find(Destination.class, destinationID);
//		List<DatesVoyages> dates=new ArrayList<DatesVoyages>();
//		for(DatesVoyages date:d.getDates()) {
//			dates.add(date);
//		}
//		dates.add(newDate);
//		d.setDates(dates);
//		this.update(d);
//		return d;
//	}

//	public Destination deleteDestinationDate(long destinationID, DatesVoyages datesToRemove) {
//		Destination d=em.find(Destination.class, destinationID);
//		List<DatesVoyages> dates=new ArrayList<DatesVoyages>();
//		for(DatesVoyages date:d.getDates()) {
//			dates.add(date);
//		}
//		Iterator<DatesVoyages> iterator = dates.iterator();
//		while (iterator.hasNext()) {
//			if (iterator.next().getId() == datesToRemove.getId()) {
//				datesVoyagesDAO.delete(datesToRemove.getId());
//				iterator.remove();
//				
//			}
//		}
//		d.setDates(dates);
//		this.update(d);
//		return d;
//	}

//	public Destination modifyDestinationDate(long destinationID, DatesVoyages newDates, long dateID) {
//		Destination d=em.find(Destination.class, destinationID);
//		List<DatesVoyages> dates=new ArrayList<DatesVoyages>();
//		for(DatesVoyages date:d.getDates()) {
//			dates.add(date);
//		}
//		Iterator<DatesVoyages> iterator = dates.iterator();
//		while (iterator.hasNext()) {
//			if (iterator.next().getId() == dateID) {
//				iterator.remove();
//			}
//		}
//		newDates.setId(dateID);
//		dates.add(newDates);
//		d.setDates(dates);
//		this.update(d);
//		return d;
//	}
	
//	public DatesVoyages getDatesById(long id) {
//		EntityManager em = getEntityManagerFactory().createEntityManager();
//		DatesVoyages dates= em.find(DatesVoyages.class, id);
//		em.close();
//		return em.find(DatesVoyages.class, id);
//	}
	
//	public List<DatesVoyages> getDestinationDates(long id) {
//		Destination d=em.find(Destination.class, id);
//		List<DatesVoyages> dates=new ArrayList<DatesVoyages>();
//		for(DatesVoyages date:d.getDates()) {
//			dates.add(date);
//		}
//		return dates;
//	}
//	
//	public void addDestinationImage(long destinationID, String nomImage) {
//		Destination d=em.find(Destination.class, destinationID);
//		Image imgToAdd=new Image(nomImage,destinationID);
//		List<Image> images=new ArrayList<Image>();
//		for(Image img:d.getImage()) {
//			images.add(img);
//		}
//		images.add(imgToAdd);
//		d.setImage(images);
//		this.update(d);
//	}
//	
//	public List<Image> getImages(Long id) {
//		Destination destination = em.find(Destination.class, id);
//		List<Image> images = new ArrayList<Image>();
//		for(Image image : destination.getImage()) {
//			images.add(image);
//		}
//		return images;
//	}

}