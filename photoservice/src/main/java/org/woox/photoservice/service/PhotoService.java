package org.woox.photoservice.service;


import java.util.List;

import org.woox.photoservice.model.Photo;

public interface PhotoService {

	public Photo getPhoto(Photo photo);
	public List<Photo> getPhotos();
	public Photo createPhoto(Photo photo);
}
