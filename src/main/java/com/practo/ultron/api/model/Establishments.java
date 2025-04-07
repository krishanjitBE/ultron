package com.practo.ultron.api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

  private List<String> doctorIds;

  private String establishmentDetailsId;


  public Establishments(List<String> doctorIds, String establishmentDetailsId) {
    this.establishmentId = UUID.randomUUID().toString();
    this.doctorIds = doctorIds;
    this.establishmentDetailsId = establishmentDetailsId;
  }
}

