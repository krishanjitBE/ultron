package com.practo.ultron.api.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstablishmentDTO {

  @NonNull
  private String sessionId;

  private String establishmentId;

  private EstablishmentDetailsDTO establishmentDetails;

  private EstablishmentMetaDataDTO establishmentMetaData;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

}
