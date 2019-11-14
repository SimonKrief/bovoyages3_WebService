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

import fr.gtm.bovoyages.entities.DatesVoyages;
import fr.gtm.bovoyages.entities.Destination;
import fr.gtm.bovoyages.entities.Image;

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
	
	public List<DatesVoyages> getDestinationDates(String id) {
		Destination d=em.find(Destination.class, Long.valueOf(id));
		List<DatesVoyages> dates=new ArrayList<DatesVoyages>();
		for(DatesVoyages date:d.getDates()) {
			dates.add(date);
		}
		return dates;
	}
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