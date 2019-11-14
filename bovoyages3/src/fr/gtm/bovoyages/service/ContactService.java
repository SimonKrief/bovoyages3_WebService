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
import fr.gtm.bovoyages.dtos.DestinationDTO;
import fr.gtm.bovoyages.entities.Destination;

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
public class ContactService {
//	
//  DAO des destinations permettant de récupérer les données	
	@EJB private DestinationDAO destinationDAO;
//	
//  methode permettant de récupérer toutes les destinations en bases de données	
	@GET                                          // la recuperation des destination est une methode de type get 
	@Path("/all")                                 // chemin d'acces à cette fonctionnalité
//	@Produces(MediaType.APPLICATION_JSON)
	@Produces("application/json;charset=utf-8")   // format des données envoyées : JSON et UTF-8
	public List<DestinationDTO> getAllContacts(){
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
	
//	@GET
//	@Path("/adresses/{id}")
////	@Produces(MediaType.APPLICATION_JSON)
//	@Produces("application/json;charset=utf-8")
//	public List<AdresseDTO> getAllAdressesById(@PathParam("id") String id){
//		List<Adresse> adresses = contactDAO.getAllAdressesContact(id);
//		List<AdresseDTO> dtos = new ArrayList<AdresseDTO>();
//		for(Adresse a : adresses) {
//			dtos.add(new AdresseDTO(a));
//		}
//		return dtos;
//	}
//	
//	@POST
//	@Path("/add")
//	@Produces(MediaType.APPLICATION_JSON)
//	public void addContact(Contact contact){
//		contactDAO.addContact(contact);
//	}
//	
//	@POST
//	@Path("/addDTO")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response addContactWSRTestClient(Contact contact){
//		ContactDTO contactDTO = contactDAO.addContactWSRTC(contact);
//		return Response.status(Status.CREATED).entity(contactDTO).build();
//	}
//	
//	@DELETE
//	@Path("/del/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public void delContact(@PathParam("id") String id){
//		contactDAO.delContact(id);
//	}
//	
//	@DELETE
//	@Path("/delC/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response delContactWSRTestClient(@PathParam("id") String id){
//		Contact contact = contactDAO.getContact(id);
//		contactDAO.delContact(id);
//		return Response.status(Status.CREATED).entity(new ContactDTO(contact)).build();
//	}
//	
//	@POST
//	@Path("/edit")
//	@Produces(MediaType.APPLICATION_JSON)
//	public void updateContact(Contact contact){
//		contactDAO.updateContact(contact);
//	}
//	
//	@POST
//	@Path("/editC")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response updateContactWSRTestClient(Contact contact){
//		Contact contactUpdated = contactDAO.updateContactWSRTestClient(contact);
//		return Response.status(Status.CREATED).entity(new ContactDTO(contactUpdated)).build();
//	}

}