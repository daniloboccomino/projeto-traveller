package br.com.fiap.rest;

import javax.ws.rs.core.Response;

public class ResponseConstants {
	
	public final static Response BAD_REQUEST = Response.status(Response.Status.BAD_REQUEST).build();

	public final static Response NOT_FOUND = Response.status(Response.Status.NOT_FOUND).build();
	
	public final static Response INTERNAL_SERVER_ERROR = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	
	public final static Response OK = Response.status(Response.Status.OK).build();
}
