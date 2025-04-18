package com.practo.ultron.api.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstablishmentDetails {

  private List<String> establishmentPhotoIds;

  private String establishmentAddressId;

  private List<String> establishmentPaymentModeIds;

  private Double establishmentRegistrationFees;

  private List<String> establishmentInsuranceProviderIds;

  private String establishmentDescription;

  private boolean establishmentOwnershipVerified;
}
