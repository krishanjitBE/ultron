package com.practo.ultron.api.model;


import com.practo.ultron.api.enums.EstablishmentServiceType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstablishmentServices {

  @Id
  private String serviceId;

  private String serviceName;

  private EstablishmentServiceType serviceType;

  public EstablishmentServices(String serviceName, EstablishmentServiceType serviceType) {
    this.serviceId = UUID.randomUUID().toString();
    this.serviceName = serviceName;
    this.serviceType = serviceType;
  }
}
