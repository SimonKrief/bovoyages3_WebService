package fr.gtm.bovoyages.service;

import java.util.List;

import fr.gtm.bovoyages.dtos.DestinationDTO;
import fr.gtm.bovoyages.dtos.VoyageDTO;
import fr.gtm.bovoyages.entities.DatesVoyages;
import fr.gtm.bovoyages.entities.Voyage;
import fr.gtm.bovoyages.entities.Voyageur;

public interface BoVoyagesServiceInterface {
//	List<Destination> getAllDestinations();
	List<DestinationDTO> getAllDestinations();

	List<DatesVoyages> getAllDatesVoyages();
	List<DestinationDTO> getAllDestinationsDatesPromotion();
	VoyageDTO creationVoyage(VoyageDTO voyage);
	public Voyageur getVoyageur();

}