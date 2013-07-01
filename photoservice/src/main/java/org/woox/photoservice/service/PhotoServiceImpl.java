package org.woox.photoservice.service;

import org.springframework.stereotype.Service;
import org.woox.photoservice.model.Photo;
import org.woox.photoservice.repository.PhotoRepository;

@Service
public class PhotoServiceImpl implements PhotoService {

	private PhotoRepository repo;
	
	public Photo getPhoto() {
		Photo myPhoto = new Photo();
		myPhoto.setTitle("my title");
		myPhoto.setData(new byte[10]);
		
		repo.save(myPhoto);
		
		return myPhoto;
	}

}
