package com.practo.ultron.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EstablishmentServiceCreateRequestDTO {

  @JsonProperty("service_name")
  private String serviceName;

  @JsonProperty("service_type")
  private String serviceType;
}
