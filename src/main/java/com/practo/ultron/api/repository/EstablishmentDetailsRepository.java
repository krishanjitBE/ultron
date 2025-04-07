package com.practo.ultron.api.repository;

import com.practo.ultron.api.model.EstablishmentDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstablishmentDetailsRepository extends MongoRepository<EstablishmentDetails, String> {
}
