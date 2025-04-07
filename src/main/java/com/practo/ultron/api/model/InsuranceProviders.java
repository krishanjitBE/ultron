package com.practo.ultron.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "establishment_insurance_providers")
public class InsuranceProviders {

  @Id
  private String id;

  private String name;

  private String photoId;


  public InsuranceProviders(String name, String photoId) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.photoId = photoId;
  }
}
