package com.practo.ultron.api.repository;

import com.practo.ultron.api.model.PaymentModes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentModeRepository extends MongoRepository<PaymentModes, String> {
}
