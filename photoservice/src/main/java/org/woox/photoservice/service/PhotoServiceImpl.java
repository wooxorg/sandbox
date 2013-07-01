package org.woox.photoservice.service;

import org.springframework.stereotype.Service;
import org.woox.photoservice.model.Photo;

@Service
public class PhotoServiceImpl implements PhotoService {

	public Photo getPhoto() {
		Photo myPhoto = new Photo();
		myPhoto.setTitle("title");
		return myPhoto;
	}

}
