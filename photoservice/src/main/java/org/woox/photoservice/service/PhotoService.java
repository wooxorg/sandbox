package org.woox.photoservice.service;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.woox.photoservice.model.Photo;
import org.woox.photoservice.repository.PhotoRepositoryImpl;

@Service
@WebService(endpointInterface = "org.woox.photoservice.service.PhotoService")
public class PhotoService implements IPhotoService {

	@Inject
	private PhotoRepositoryImpl repository;

	
	@Override
	public byte[] uploadPhoto(MultipartBody p_attachment) {
		Photo photo = new Photo();
		if (StringUtils.hasText(photo.getId())) {
			repository.updatePhoto(photo);
		} else {
			repository.addPhoto(photo);
		}

		return photo.getData();
	}

	@Override
	public Photo getPhoto(Photo photo) {
		// repository.getPhoto(photo);
		return new Photo();
	}


	@Override
	public List<Photo> getPhotos() {
		return repository.listPhoto();
	}

}
