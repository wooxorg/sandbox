package org.woox.photoservice.repository;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.woox.photoservice.model.Photo;

//TODO WriteConcern.SAFE ? http://docs.mongodb.org/ecosystem/drivers/java-concurrency/

@Repository
public class PhotoRepositoryImpl {

	@Inject
	private MongoTemplate mongoTemplate;

	//public static final String COLLECTION_NAME = "photo";

	public void addPhoto(Photo photo) {
		if (!mongoTemplate.collectionExists(Photo.class)) {
			mongoTemplate.createCollection(Photo.class);
		}
		photo.setId(UUID.randomUUID().toString());

		//mongoTemplate.insert(photo, COLLECTION_NAME);
		mongoTemplate.insert(photo);
	}

	public List<Photo> listPhoto() {
		//return mongoTemplate.findAll(Photo.class, COLLECTION_NAME);
		return mongoTemplate.findAll(Photo.class);
	}


	public void deletePhoto(Photo photo) {
		//mongoTemplate.remove(photo, COLLECTION_NAME);
		mongoTemplate.remove(photo);
	}

	public void updatePhoto(Photo photo) {
		//mongoTemplate.insert(photo, COLLECTION_NAME);
		mongoTemplate.insert(photo);
	}
	
	//TODO verify 
	public Photo getPhoto(Photo photo) {
		return mongoTemplate.findById(photo.getId(), Photo.class);
	}
}
