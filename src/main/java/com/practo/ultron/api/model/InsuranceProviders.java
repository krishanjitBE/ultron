package com.practo.ultron.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceProviders {

  @Id
  private String insuranceProviderId;

  private String insuranceProviderName;

  private List<String> insurancePhotoIds;


  public InsuranceProviders(String insuranceProviderName, List<String> insurancePhotoIds) {
    this.insuranceProviderId = UUID.randomUUID().toString();
    this.insuranceProviderName = insuranceProviderName;
    this.insurancePhotoIds = insurancePhotoIds;
  }
}
