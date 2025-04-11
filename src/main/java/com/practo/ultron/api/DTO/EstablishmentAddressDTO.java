package com.practo.ultron.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstablishmentAddressDTO {

  private String id;
  private String addressLine;
  private String landmark;
  private String locality;
  private String city;
  private String country;
  private Integer zipcode;
}