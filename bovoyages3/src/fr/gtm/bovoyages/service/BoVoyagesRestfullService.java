package fr.gtm.bovoyages.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.gtm.bovoyages.dao.DestinationDAO;
import fr.gtm.bovoyages.dtos.DatesVoyagesDTO;
import fr.gtm.bovoyages.dtos.DestinationDTO;
import fr.gtm.bovoyages.dtos.VoyageDTO;
import fr.gtm.bovoyages.dtos.VoyageurDTO;
import fr.gtm.bovoyages.entities.Client;
import fr.gtm.bovoyages.entities.DatesVoyages;
import fr.gtm.bovoyages.entities.Destination;
import fr.gtm.bovoyages.entities.Voyage;
import fr.gtm.bovoyages.entities.Voyageur;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//                                                         COUCHE DE SERVICE
//
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//  annotation specifiant le chemin d'acces à cette couche une fois que le chemmin du web service a été entré
@Path("/destinations")
public class BoVoyagesRestfullService {
//	
//  DAO des destinations permettant de récupérer les données	
	@EJB private DestinationDAO destinationDAO;
//	
//  methode permettant de récupérer toutes les destinations en bases de données	
	@GET                                          // la recuperation des destination est une methode de type get 
	@Path("/all")                                 // chemin d'acces à cette fonctionnalité
//	@Produces(MediaType.APPLICATION_JSON)
	@Produces("application/json;charset=utf-8")   // format des données envoyées : JSON et UTF-8
	public List<DestinationDTO> getAllDestinations(){
		List<DestinationDTO> dtos = new ArrayList<DestinationDTO>();
		List<Destination> destinations = destinationDAO.getDestinations();
		for(Destination d : destinations) {
			dtos.add(new DestinationDTO(d));
		}
		return dtos;
	}
	
//  methode permettant de récupérer toutes les regions disponibles avec les destinations en bases de données	
	@GET                                          // la recuperation des destination est une methode de type get 
	@Path("/allRegions")                                 // chemin d'acces à cette fonctionnalité
//	@Produces(MediaType.APPLICATION_JSON)
	@Produces("application/json;charset=utf-8")   // format des données envoyées : JSON et UTF-8
	public List<String> getAllRegions(){
		List<String> regions = new ArrayList<String>();
		List<Destination> destinations = destinationDAO.getDestinations();
		for(Destination d : destinations) {
			if(!regions.contains(d.getRegion())) {
				regions.add(d.getRegion());
			}
		}
		
		return regions;
	}
	
//  methode permettant de récupérer toutes les regions disponibles avec les destinations en bases de données	
	@GET                                          // la recuperation des destination est une methode de type get 
	@Path("/allDestinationsValides")                                 // chemin d'acces à cette fonctionnalité
//	@Produces(MediaType.APPLICATION_JSON)
	@Produces("application/json;charset=utf-8")   // format des données envoyées : JSON et UTF-8
	public List<DestinationDTO> getAllDestinationsValides(){
		List<DestinationDTO> dtos = new ArrayList<DestinationDTO>();
		List<Destination> destinations = destinationDAO.getDestinations();
		for(Destination d : destinations) {
			if(d.getDeleted() == 0) {
				dtos.add(new DestinationDTO(d));
			}
		}
		return dtos;
	}

	@POST
	@Path("/addClient")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClient(Client client){
		List<Client> clients = destinationDAO.addClient(client);
		
		return Response.status(Status.CREATED).entity(clients.get(clients.size()-1)).build();
	}	
	
	@POST
	@Path("/addVoyage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addVoyage(Voyage voyage){
		List<Voyage> voyages = destinationDAO.addVoyage(voyage);
		
		return Response.status(Status.CREATED).entity(voyages.get(voyages.size()-1)).build();
	}
	
	@POST
	@Path("/updateVoyage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateVoyage(Voyage voyage){
		Voyage voyageReponse = destinationDAO.updateVoyage(voyage);
		
		return Response.status(Status.CREATED).entity(voyageReponse).build();
	}
	
	@POST
	@Path("/updateVoyageurDeVoyage/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateVoyage(Voyageur voyageur ,@PathParam("id") String id){
		Voyage voyageMAJ = destinationDAO.updateVoyageurDeVoyage(voyageur, id);
		VoyageDTO voyageDTO = new VoyageDTO(voyageMAJ);
		voyageDTO.setParticipants(voyageMAJ.getParticipants());
		
		return Response.status(Status.CREATED).entity(voyageDTO).build();
	}
	
	@POST
	@Path("/addClientVoyage/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClientVoyage(Client client ,@PathParam("id") String id){
		Voyage voyageReponse = destinationDAO.addClientVoyage(client,id);
		
		return Response.status(Status.CREATED).entity(new VoyageDTO(voyageReponse)).build();
	}
	
	@POST
	@Path("/addVoyageurAVoyage/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addVoyageurAVoyage(Voyageur[] voyageurs,@PathParam("id") String id){
		List<Voyageur> voyageursReponse = destinationDAO.addVoyageurAVoyage(voyageurs,id);
		List<VoyageurDTO> dtos = new ArrayList<VoyageurDTO>();
		for(Voyageur voyageur : voyageursReponse) {
			dtos.add(new VoyageurDTO(voyageur));
		}
		return Response.status(Status.CREATED).entity(dtos).build();
	}
	
//  methode permettant de récupérer toutes les dates valides d'une destination	
	@GET//                                                  l'envoi d'une destination dont on souhaite les dates de voyages necessite un post 
	@Path("/allDatesVoyagesValidesDeDestination/{id}")//    chemin d'acces à cette fonctionnalité
	@Consumes(MediaType.APPLICATION_JSON)//
	@Produces(MediaType.APPLICATION_JSON)//                 format des données envoyées : JSON et UTF-8
	public Response getAllDatesVoyagesValidesDeDestination(@PathParam("id") String id){
		List<DatesVoyages> datesVoyages = destinationDAO.getDestinationDates(id);
		List<DatesVoyagesDTO> dtos = new ArrayList<DatesVoyagesDTO>();
		for(DatesVoyages d : datesVoyages) {
			if(d.getDeleted() == 0) {
				dtos.add(new DatesVoyagesDTO(d));
			}
		}
		return Response.status(Status.CREATED).entity(dtos).build();
	}
	
	@POST
	@Path("/commandeVoyageEnregistre/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response commandeVoyageEnregistre(Voyage voyage,@PathParam("id") String id){
		boolean bool = destinationDAO.commandeVoyageEnregistre(voyage,id);
		return Response.status(Status.CREATED).entity(bool).build();
	}
	
	@POST
	@Path("/commandeVoyage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response commandeVoyage(Voyage voyage){
		boolean bool = destinationDAO.commandeVoyage(voyage);
		return Response.status(Status.CREATED).entity(bool).build();
	}
	
}