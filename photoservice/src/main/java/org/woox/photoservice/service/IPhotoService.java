package org.woox.photoservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.woox.photoservice.model.Photo;

@WebService
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Path("/")
public interface IPhotoService {

	@GET
	@Path("get")
	@WebMethod
	public Photo getPhoto(Photo photo);

	@GET
	@Path("getPhotos")
	@WebMethod
	public List<Photo> getPhotos();
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("uploadPhoto")
	@WebMethod
	public byte[] uploadPhoto(@Multipart("file") MultipartBody p_attachment);
}
