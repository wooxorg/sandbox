package org.woox.photoservice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.woox.photoservice.model.Photo;
import org.woox.photoservice.repository.PhotoRepositoryImpl;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Inject
	private PhotoRepositoryImpl repository;

	@Override
	public Photo createPhoto(Photo photo) {
		if (StringUtils.hasText(photo.getId())) {
			repository.updatePhoto(photo);
		} else {
			repository.addPhoto(photo);
		}

		return photo;
	}

	@Override
	public Photo getPhoto(Photo photo) {
		return repository.getPhoto(photo);
	}

	@Override
	public List<Photo> getPhotos() {
		return repository.listPhoto();
	}

}
