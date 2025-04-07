package com.practo.ultron.api.repository;

import com.practo.ultron.api.model.InsuranceProviders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InsuranceProviderRepository extends MongoRepository<InsuranceProviders, String> {
}
