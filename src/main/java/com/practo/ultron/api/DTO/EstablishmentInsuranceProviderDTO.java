package com.practo.ultron.api.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EstablishmentInsuranceProviderDTO {

  private String insuranceProviderName;

  private List<String> insurancePhotoIds;

}
