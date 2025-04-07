package com.practo.ultron.api.service;

import com.practo.ultron.api.DTO.EstablishmentServiceCreateRequestDTO;
import com.practo.ultron.api.enums.EstablishmentServiceType;
import com.practo.ultron.api.model.EstablishmentServices;
import com.practo.ultron.api.repository.EstablishmentServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentServicesServiceImpl implements EstablishmentServicesService {

  @Autowired
  EstablishmentServicesRepository establishmentServicesRepository;


  @Override
  public boolean postEstablishmentServices(EstablishmentServiceCreateRequestDTO dto) {

    String serviceType = dto.getServiceType().toUpperCase();
    EstablishmentServices services = EstablishmentServices.builder()
        .serviceName(dto.getServiceName())
        .serviceType(EstablishmentServiceType.valueOf(serviceType))
        .build();

    try {
      establishmentServicesRepository.save(services);
      return true;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
