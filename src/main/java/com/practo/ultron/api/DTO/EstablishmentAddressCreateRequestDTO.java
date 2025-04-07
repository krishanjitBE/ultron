package com.practo.ultron.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class EstablishmentAddressCreateRequestDTO implements Serializable {

  @JsonProperty("address_line")
  private String addressLine;

  @JsonProperty("landmark")
  private String landmark;

  @JsonProperty("locality")
  private String locality;

  @JsonProperty("city")
  private String city;

  @JsonProperty("country")
  private String country;

  @JsonProperty("zipcode")
  private String zipcode;
}
