package fr.gtm.bovoyages.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import fr.gtm.bovoyages.dao.DestinationDAO;
import fr.gtm.bovoyages.dtos.DestinationDTO;
import fr.gtm.bovoyages.entities.Destination;

@Stateless
@WebService
public class BoVoyagesService implements BoVoyagesServiceRemote {
	// http://localhost:9080/bovoyages3/BoVoyagesService?wsdl
	@Inject
	private DestinationDAO dao;

//	@Override
//	public List<Destination> getAllDestinations() {
//		return dao.getDestinations();
//	}
	
	
	@Override
	public  List<DestinationDTO> getAllDestinations() {
		List<DestinationDTO> dtos = new ArrayList<DestinationDTO>();
		List<Destination> destinations = dao.getDestinations();
		for(Destination d : destinations) {
			dtos.add(new DestinationDTO(d));
		}
		return dtos;
	}

	
	
}
