package fr.gtm.bovoyages.service;

import java.util.List;

import fr.gtm.bovoyages.dtos.DestinationDTO;
import fr.gtm.bovoyages.entities.DatesVoyages;

public interface BoVoyagesServiceInterface {
//	List<Destination> getAllDestinations();
	List<DestinationDTO> getAllDestinations();

	List<DatesVoyages> getAllDatesVoyages();
	List<DestinationDTO> getAllDestinationsDatesPromotion();


}