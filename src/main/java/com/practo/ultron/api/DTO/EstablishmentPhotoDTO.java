package com.practo.ultron.api.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstablishmentPhotoDTO {

  private String id;

  private String type;

  private String url;
}