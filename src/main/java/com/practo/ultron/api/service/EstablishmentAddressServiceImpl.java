package com.practo.ultron.api.service;

import com.practo.ultron.api.DTO.EstablishmentAddressCreateRequestDTO;
import com.practo.ultron.api.model.EstablishmentAddress;
import com.practo.ultron.api.repository.EstablishmentAddressRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class EstablishmentAddressServiceImpl implements EstablishmentAddressService {

  @Autowired
  EstablishmentAddressRepository establishmentAddressRepository;

  @Override
  public boolean postEstablishmentAddress(EstablishmentAddressCreateRequestDTO dto) {

    log.info("DTO : {}", dto);

    EstablishmentAddress address = EstablishmentAddress.builder()
        .addressLine(dto.getAddressLine())
        .landmark(dto.getLandmark())
        .locality(dto.getLocality())
        .city(dto.getCity())
        .country(dto.getCountry())
        .zipcode(dto.getZipcode())
        .build();

    log.info("Address : {}", address);

    try {
      establishmentAddressRepository.save(address);
      return true;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
