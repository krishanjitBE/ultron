package com.practo.ultron.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EstablishmentCreateRequestDTO {

  @JsonProperty("doctor_ids")
  private List<String> doctorIds;

  @JsonProperty("establishment_details_id")
  private String establishmentDetailsId;
}
