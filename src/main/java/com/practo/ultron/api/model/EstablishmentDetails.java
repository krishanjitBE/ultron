package com.practo.ultron.api.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "establishment_details")
public class EstablishmentDetails {

  @Id
  private String EstablishmentDetailsId;

  private String addressId;

  private String paymentModeId;

  private Double registrationFees;

  private String insuranceId;

  private String description;

  private boolean ownershipVerified;

  public EstablishmentDetails(String addressId, String paymentModeId, Double registrationFees,
                              String insuranceId, String description, boolean ownershipVerified) {
    this.EstablishmentDetailsId = UUID.randomUUID().toString();
    this.addressId = addressId;
    this.paymentModeId = paymentModeId;
    this.registrationFees = registrationFees;
    this.insuranceId = insuranceId;
    this.description = description;
    this.ownershipVerified = ownershipVerified;
  }
}
