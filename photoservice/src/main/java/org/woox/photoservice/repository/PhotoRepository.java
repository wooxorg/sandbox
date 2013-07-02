package org.woox.photoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.woox.photoservice.model.Photo;

// TODO keep interface?
@Repository
public interface PhotoRepository extends MongoRepository<Photo,String> {
	
}
