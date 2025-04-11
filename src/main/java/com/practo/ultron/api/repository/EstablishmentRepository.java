package com.practo.ultron.api.repository;

import com.practo.ultron.api.model.Establishments;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EstablishmentRepository extends MongoRepository<Establishments, String> {

  Optional<Establishments> findBySessionId(String sessionId);
}
