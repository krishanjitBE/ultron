package com.practo.ultron.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class EstablishmentPhotoCreateRequestDTO implements Serializable {

  @JsonProperty("photo_type")
  private String photoType;

  @JsonProperty("photo_url")
  private String photoUrl;
}
