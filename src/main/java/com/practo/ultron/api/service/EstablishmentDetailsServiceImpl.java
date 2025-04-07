package com.practo.ultron.api.service;

import com.practo.ultron.api.DTO.EstablishmentDetailsCreateRequestDTO;
import com.practo.ultron.api.model.EstablishmentDetails;
import com.practo.ultron.api.model.EstablishmentServices;
import com.practo.ultron.api.repository.EstablishmentAddressRepository;
import com.practo.ultron.api.repository.EstablishmentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentDetailsServiceImpl implements EstablishmentDetailsService {

  @Autowired
  EstablishmentAddressRepository establishmentAddressRepository;

  @Autowired
  EstablishmentDetailsRepository establishmentDetailsRepository;


  @Override
  public boolean postEstablishmentDetails(EstablishmentDetailsCreateRequestDTO dto) {

    establishmentAddressRepository.findById(
        dto.getAddressId()).orElseThrow(() -> new RuntimeException(
            "Establishment address not found with ID: " + dto.getAddressId()));

    EstablishmentDetails establishmentDetails = EstablishmentDetails.builder()
        .addressId(dto.getAddressId())
        .registrationFees(dto.getRegistrationFees())
        .description(dto.getDescription())
        .ownershipVerified(dto.isOwnershipVerified())
        .build();

    try {

      establishmentDetailsRepository.save(establishmentDetails);
      return true;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
