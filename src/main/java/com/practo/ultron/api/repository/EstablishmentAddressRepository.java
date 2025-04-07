package com.practo.ultron.api.repository;

import com.practo.ultron.api.model.EstablishmentAddress;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstablishmentAddressRepository extends MongoRepository<EstablishmentAddress, String> {
}
