package com.practo.ultron.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstablishmentDetailsDTO {

  private List<String> establishmentPhotoIds;

  private String establishmentAddressId;

  private List<String> establishmentPaymentModeIds;

  private Double establishmentRegistrationFees;

  private List<String> establishmentInsuranceProviderIds;

  private String establishmentDescription;

  private boolean establishmentOwnershipVerified;

}
