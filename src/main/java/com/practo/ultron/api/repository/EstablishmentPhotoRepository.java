package com.practo.ultron.api.repository;

import com.practo.ultron.api.model.EstablishmentPhotos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstablishmentPhotoRepository extends MongoRepository<EstablishmentPhotos, String> {
}
