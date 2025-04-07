package com.practo.ultron.api.model;


import com.practo.ultron.api.enums.EstablishmentPhotoType;
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
@Document(collection = "establishment_photos")
@Builder
public class EstablishmentPhotos {

  @Id
  private String establishmentPhotoId;

  private EstablishmentPhotoType establishmentPhotoType;

  private String photoUrl;


  public EstablishmentPhotos(EstablishmentPhotoType establishmentPhotoType, String photoUrl) {
    this.establishmentPhotoId = UUID.randomUUID().toString();
    this.establishmentPhotoType = establishmentPhotoType;
    this.photoUrl = photoUrl;
  }
}
