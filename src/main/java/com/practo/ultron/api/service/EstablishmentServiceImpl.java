package com.practo.ultron.api.service;

import com.practo.ultron.api.DTO.EstablishmentDTO;
import com.practo.ultron.api.DTO.EstablishmentDetailsDTO;
import com.practo.ultron.api.DTO.EstablishmentMetaDataDTO;
import com.practo.ultron.api.enums.EstablishmentPhotoType;
import com.practo.ultron.api.enums.EstablishmentServiceType;
import com.practo.ultron.api.httpResponse.EstablishmentHTTPResponse;
import com.practo.ultron.api.mapper.EstablishmentMapper;
import com.practo.ultron.api.model.*;
import com.practo.ultron.api.repository.EstablishmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Component
@Log4j2
public class EstablishmentServiceImpl implements EstablishmentService {

  @Autowired
  EstablishmentRepository establishmentRepository;


  @Override
  public EstablishmentHTTPResponse postData(EstablishmentDTO dto) {

    if (ObjectUtils.isEmpty(dto.getSessionId())) {
      return new EstablishmentHTTPResponse(
          false, "Invalid request: Session ID is required", null);
    }

    Optional<Establishments> existingEstablishment = establishmentRepository
        .findBySessionId(dto.getSessionId());

    try {
      return existingEstablishment
          .map(establishment -> {
            updateEstablishmentData(dto, existingEstablishment.get());
            return new EstablishmentHTTPResponse(
                true, "Establishment updated successfully", dto.getSessionId());
          })
          .orElseGet(() -> {
            createNewEstablishmentData(dto);
            return new EstablishmentHTTPResponse(
                true, "Establishment created successfully", dto.getSessionId());
          });
    } catch (Exception e) {
      log.error("Error processing establishment data for sessionId: {}", dto.getSessionId(), e);
      return new EstablishmentHTTPResponse(
          false, "Failed to process establishment data: " + e.getMessage(), dto.getSessionId());
    }
  }

  @Override
  public EstablishmentDTO getData(String establishmentId) throws Exception {
    Optional<Establishments> establishment = establishmentRepository.findById(establishmentId);

    if (establishment.isEmpty()) {
      throw new Exception();
    }

    return EstablishmentMapper.fromEntity(establishment.get());

  }

  private void createNewEstablishmentData(EstablishmentDTO dto) {
    log.info("Creating new establishment");
    Establishments establishment = EstablishmentMapper.toEntity(dto);
    establishmentRepository.save(establishment);
  }

  private void updateEstablishmentData(EstablishmentDTO dto, Establishments existing) {
    log.info("Updating existing establishment for sessionId: {}", dto.getSessionId());


    if (dto.getEstablishmentDetails() != null) {
      if (existing.getEstablishmentDetails() == null) {
        existing.setEstablishmentDetails(new EstablishmentDetails());
      }
      EstablishmentDetails details = existing.getEstablishmentDetails();
      EstablishmentDetailsDTO detailsDTO = dto.getEstablishmentDetails();

      if (detailsDTO.getEstablishmentPhotoIds() != null) {
        details.setEstablishmentPhotoIds(detailsDTO.getEstablishmentPhotoIds());
      }
      if (detailsDTO.getEstablishmentAddressId() != null) {
        details.setEstablishmentAddressId(detailsDTO.getEstablishmentAddressId());
      }
      if (detailsDTO.getEstablishmentPaymentModeIds() != null) {
        details.setEstablishmentPaymentModeIds(detailsDTO.getEstablishmentPaymentModeIds());
      }
      if (detailsDTO.getEstablishmentRegistrationFees() != 0) {
        details.setEstablishmentRegistrationFees(detailsDTO.getEstablishmentRegistrationFees());
      }
      if (detailsDTO.getEstablishmentInsuranceProviderIds() != null) {
        details.setEstablishmentInsuranceProviderIds(detailsDTO.getEstablishmentInsuranceProviderIds());
      }
      if (detailsDTO.getEstablishmentDescription() != null) {
        details.setEstablishmentDescription(detailsDTO.getEstablishmentDescription());
      }
      details.setEstablishmentOwnershipVerified(detailsDTO.isEstablishmentOwnershipVerified());
    }

    if (dto.getEstablishmentMetaData() != null) {
      if (existing.getEstablishmentMetaData() == null) {
        existing.setEstablishmentMetaData(null);
      }

      EstablishmentMetaData meta = existing.getEstablishmentMetaData();
      EstablishmentMetaDataDTO metaDTO = dto.getEstablishmentMetaData();

      if (metaDTO.getEstablishmentPhoto() != null) {
        EstablishmentPhotos photos = new EstablishmentPhotos();
        photos.setEstablishmentPhotoType(Enum.valueOf(
            EstablishmentPhotoType.class, metaDTO.getEstablishmentPhoto().getType()));
        photos.setPhotoUrl(metaDTO.getEstablishmentPhoto().getUrl());
        meta.setEstablishmentPhotos(photos);
      }

      if (metaDTO.getEstablishmentAddress() != null) {
        EstablishmentAddress address = new EstablishmentAddress();
        address.setAddressLine(metaDTO.getEstablishmentAddress().getAddressLine());
        address.setLandmark(metaDTO.getEstablishmentAddress().getLandmark());
        address.setLocality(metaDTO.getEstablishmentAddress().getLocality());
        address.setCity(metaDTO.getEstablishmentAddress().getCity());
        address.setCountry(metaDTO.getEstablishmentAddress().getCountry());
        address.setZipcode(String.valueOf(metaDTO.getEstablishmentAddress().getZipcode()));
        meta.setEstablishmentAddress(address);
      }

      if (metaDTO.getEstablishmentServices() != null) {
        EstablishmentServices services = new EstablishmentServices();
        services.setServiceName(metaDTO.getEstablishmentServices().getName());
        services.setServiceType(Enum.valueOf(
            EstablishmentServiceType.class, metaDTO.getEstablishmentServices().getType()));
        meta.setEstablishmentServices(services);
      }
    }

    establishmentRepository.save(existing);
    log.info("Establishment with sessionId {} updated successfully", dto.getSessionId());
  }

}
