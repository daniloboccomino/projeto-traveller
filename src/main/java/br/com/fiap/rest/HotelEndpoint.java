package br.com.fiap.rest;

import static br.com.fiap.rest.ResponseConstants.BAD_REQUEST;
import static br.com.fiap.rest.ResponseConstants.INTERNAL_SERVER_ERROR;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.dao.HotelDAO;
import br.com.fiap.model.Hotel;
import br.com.fiap.util.EntityManagerFacade;

@Path("/hotels")
@Produces(MediaType.APPLICATION_JSON)
public class HotelEndpoint {
private EntityManager manager = new EntityManagerFacade().getEntityManager();
	
	private HotelDAO dao = new HotelDAO(manager);
	
	@GET
	public List<Hotel> index() {
		return dao.searchByName("");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Hotel hotel) {
		if (hotel == null) {
			return BAD_REQUEST;
		}
		try {
			dao.insert(hotel);
			return Response.status(Response.Status.CREATED).entity(hotel).build();
		} catch (Exception e) {
			return INTERNAL_SERVER_ERROR;
		}
	}
	
	
}
