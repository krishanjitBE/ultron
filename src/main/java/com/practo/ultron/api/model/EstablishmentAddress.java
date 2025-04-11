package com.practo.ultron.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstablishmentAddress {

  @Id
  private String addressId;

  private String addressLine;

  private String landmark;

  private String locality;

  private String city;

  private String country;

  private String zipcode;


  public EstablishmentAddress(String addressLine, String landmark, String locality,
                              String city, String country, String zipcode) {
    this.addressId = UUID.randomUUID().toString();
    this.addressLine = addressLine;
    this.landmark = landmark;
    this.locality = locality;
    this.city = city;
    this.country = country;
    this.zipcode = zipcode;
  }
}
