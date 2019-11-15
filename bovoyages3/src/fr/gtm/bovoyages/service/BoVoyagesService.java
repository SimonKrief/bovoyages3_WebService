package fr.gtm.bovoyages.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import fr.gtm.bovoyages.dao.DatesVoyagesDAO;
import fr.gtm.bovoyages.dao.DestinationDAO;
import fr.gtm.bovoyages.dtos.DestinationDTO;
import fr.gtm.bovoyages.dtos.VoyageDTO;
import fr.gtm.bovoyages.entities.DatesVoyages;
import fr.gtm.bovoyages.entities.Destination;
import fr.gtm.bovoyages.entities.Voyage;
import fr.gtm.bovoyages.entities.Voyageur;

@Stateless
@WebService
public class BoVoyagesService implements BoVoyagesServiceRemote {
	// http://localhost:9080/bovoyages3/BoVoyagesService?wsdl
	@Inject
	private DestinationDAO dao;
	@Inject
	private DatesVoyagesDAO daoDate;

//	@Override
//	public List<Destination> getAllDestinations() {
//		return dao.getDestinations();
//	}

	@Override
	public List<DestinationDTO> getAllDestinations() {
		List<DestinationDTO> dtos = new ArrayList<DestinationDTO>();
		List<Destination> destinations = dao.getDestinations();
		for (Destination d : destinations) {
			dtos.add(new DestinationDTO(d));
		}
		return dtos;
	}

	@Override
	public List<DatesVoyages> getAllDatesVoyages() {
//		List<DatesVoyages> datesVoyages = daoDate.getAllDatesVoyages();
//		List<DatesVoyagesDTO> datesVoyages = new ArrayList<DatesVoyagesDTO>();
		return daoDate.getAllDatesVoyages();
	}

	@Override
	public List<DestinationDTO> getAllDestinationsDatesPromotion() {
//		List<DestinationDTO> dtos = new ArrayList<DestinationDTO>();
//		List<Destination> destinations = dao.getDestinationsDatesPromotion();
//		for (Destination d : destinations) {
//			dtos.add(new DestinationDTO(d));
//		}
		List<DestinationDTO> dtos = dao.getDestinationsDatesPromotion();
		return dtos;
	}
	
	@Override
	public VoyageDTO creationVoyage(VoyageDTO voyage) {
		Voyage voyageRetour = dao.creationVoyage(voyage);
		return new VoyageDTO(voyageRetour);
	}
	
	@Override
	public Voyageur getVoyageur() {
		Voyageur voyageur = new Voyageur();
		return voyageur;
	}

}