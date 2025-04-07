package com.practo.ultron.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EstablishmentDetailsCreateRequestDTO {

  @JsonProperty("address_id")
  private String addressId;

  @JsonProperty("registration_fees")
  private Double registrationFees;

  @JsonProperty("description")
  private String description;

  @JsonProperty("ownership_verified")
  private boolean ownershipVerified;
}
