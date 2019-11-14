package fr.gtm.bovoyages.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.bovoyages.entities.DatesVoyages;
import fr.gtm.bovoyages.entities.Destination;

@Singleton
public class DatesVoyagesDAO {
	private Logger LOG = Logger.getLogger("SERVEUR-DAO");

	@PersistenceContext(name="bovoyages") private EntityManager em;
	
	public DatesVoyagesDAO() {}
	
	public void create(DatesVoyages datesVoyages) {
		em.persist(datesVoyages);
	}
	
	public void delete(long id) {
		em.remove(em.find(DatesVoyages.class, id));
	}
	
	public void update(DatesVoyages datesVoyages) {
		em.merge(datesVoyages);
	}

	public DatesVoyages getDatesVoyagesById(long id) {
		return em.find(DatesVoyages.class, id);
	}
	
	
	public List<DatesVoyages> getAllDatesVoyages() {
		LOG.info("recuperation des dates");
		return em.createNamedQuery("DatesVoyages.getAllDatesVoyages", DatesVoyages.class).getResultList();
	} 
}
