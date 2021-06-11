package br.com.fiap.rest;

import static br.com.fiap.rest.ResponseConstants.BAD_REQUEST;
import static br.com.fiap.rest.ResponseConstants.INTERNAL_SERVER_ERROR;
import static br.com.fiap.rest.ResponseConstants.NOT_FOUND;
import static br.com.fiap.rest.ResponseConstants.OK;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.model.User;
import br.com.fiap.util.EntityManagerFacade;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserEndpoint {
	private EntityManager manager = new EntityManagerFacade().getEntityManager();
	
	private UserDAO dao = new UserDAO(manager);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		if (user == null) {
			return BAD_REQUEST;
		}
		try {
			dao.insert(user);
			return Response.status(Response.Status.CREATED).entity(user).build();
		} catch (Exception e) {
			return INTERNAL_SERVER_ERROR;
		}
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, User user) {
		if (id == 0 || user == null) {
			return BAD_REQUEST;
		}
		
		try {
			dao.select(id);
		} catch (EntityNotFoundException e1) {
			return NOT_FOUND;
		}
		
		user.setId(id);
		try {
			dao.update(user);
			return Response.status(Response.Status.OK).entity(user).build();
		} catch (Exception e) {
			return INTERNAL_SERVER_ERROR;
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response destroy(@PathParam("id") int id) {
		if (id == 0) {
			return BAD_REQUEST;
		}
		try {
			dao.select(id);
		} catch (Exception e) {
			return NOT_FOUND;
		}
		
		try {
			dao.delete(id);
			return OK;
		} catch (Exception e) {
			return INTERNAL_SERVER_ERROR;
		}
	}
}
