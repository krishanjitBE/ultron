package com.practo.ultron.api.repository;

import com.practo.ultron.api.model.Establishments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstablishmentRepository extends MongoRepository<Establishments, String> {
}
