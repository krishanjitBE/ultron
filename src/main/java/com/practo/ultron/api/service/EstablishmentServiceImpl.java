package com.practo.ultron.api.service;

import com.practo.ultron.api.DTO.EstablishmentCreateRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class EstablishmentServiceImpl implements EstablishmentService{

  @Override
  public boolean postEstablishmentData(EstablishmentCreateRequestDTO dto) {
    return false;
  }
}
