package com.practo.ultron.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstablishmentMetaDataDTO implements Serializable {

  private EstablishmentPhotoDTO establishmentPhoto;

  private EstablishmentAddressDTO establishmentAddress;

  private EstablishmentServiceDTO establishmentServices;

  private EstablishmentInsuranceProviderDTO establishmentInsuranceProviders;

  private EstablishmentPaymentModeDTO establishmentPaymentModes;

}
