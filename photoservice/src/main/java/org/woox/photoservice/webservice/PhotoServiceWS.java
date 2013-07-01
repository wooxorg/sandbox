package org.woox.photoservice.webservice;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.woox.photoservice.model.Photo;
import org.woox.photoservice.service.PhotoServiceImpl;


@Path("/")
public class PhotoServiceWS {

	@Inject
	private PhotoServiceImpl photoService;

	@Produces({MediaType.APPLICATION_JSON})
	@GET
	@Path("/get")
	public Photo getPhoto() {
		return photoService.getPhoto();
	}


}
