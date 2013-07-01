package org.woox.photoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.woox.photoservice.model.Photo;

@Transactional
@Repository
public interface PhotoRepository extends MongoRepository<Photo,String> {

}
