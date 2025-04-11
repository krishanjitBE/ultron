package com.practo.ultron.api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "establishments")
public class Establishments {

  @Id
  private String establishmentId;

  private String sessionId;

  private EstablishmentDetails establishmentDetails;

  private EstablishmentMetaData establishmentMetaData;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;


  public Establishments(EstablishmentDetails establishmentDetails,
                        String sessionId, EstablishmentMetaData establishmentMetaData) {
    this.establishmentId = UUID.randomUUID().toString();
    this.sessionId = sessionId;
    this.establishmentDetails = establishmentDetails;
    this.establishmentMetaData = establishmentMetaData;
  }
}

