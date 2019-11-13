package fr.gtm.bovoyages.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.bovoyages.entities.DatesVoyages;

@Singleton
public class DatesVoyagesDAO {

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
	
	
}
