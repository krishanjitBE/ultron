package com.practo.ultron.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstablishmentMetaData {

  private EstablishmentPhotos establishmentPhotos;

  private EstablishmentAddress establishmentAddress;

  private EstablishmentServices establishmentServices;

  private InsuranceProviders insuranceProviders;

  private PaymentModes paymentModes;

}
