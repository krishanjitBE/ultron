package com.practo.ultron.api.mapper;

import com.practo.ultron.api.DTO.*;
import com.practo.ultron.api.enums.EstablishmentPhotoType;
import com.practo.ultron.api.enums.EstablishmentServiceType;
import com.practo.ultron.api.model.*;

import java.time.LocalDateTime;

public class EstablishmentMapper {

  public static Establishments toEntity(EstablishmentDTO dto) {
    return Establishments.builder()
        .sessionId(dto.getSessionId())
        .establishmentDetails(toDetails(dto.getEstablishmentDetails()))
        .establishmentMetaData(toMetadata(dto.getEstablishmentMetaData()))
        .build();
  }

  private static EstablishmentDetails toDetails(EstablishmentDetailsDTO dto) {
    if (dto == null) return null;

    return EstablishmentDetails.builder()
        .establishmentPhotoIds(dto.getEstablishmentPhotoIds())
        .establishmentAddressId(dto.getEstablishmentAddressId())
        .establishmentPaymentModeIds(dto.getEstablishmentPaymentModeIds())
        .establishmentRegistrationFees(dto.getEstablishmentRegistrationFees())
        .establishmentInsuranceProviderIds(dto.getEstablishmentInsuranceProviderIds())
        .establishmentDescription(dto.getEstablishmentDescription())
        .establishmentOwnershipVerified(dto.isEstablishmentOwnershipVerified())
        .build();
  }

  private static EstablishmentMetaData toMetadata(EstablishmentMetaDataDTO dto) {
    if (dto == null) return null;

    return EstablishmentMetaData.builder()
        .establishmentPhotos(
            dto.getEstablishmentPhoto() != null ? EstablishmentPhotos.builder()
                .establishmentPhotoType(EstablishmentPhotoType.valueOf(dto.getEstablishmentPhoto().getType()))
                .photoUrl(dto.getEstablishmentPhoto().getUrl())
                .build() : null)
        .establishmentAddress(
            dto.getEstablishmentAddress() != null ? EstablishmentAddress.builder()
                .addressLine(dto.getEstablishmentAddress().getAddressLine())
                .landmark(dto.getEstablishmentAddress().getLandmark())
                .locality(dto.getEstablishmentAddress().getLocality())
                .city(dto.getEstablishmentAddress().getCity())
                .country(dto.getEstablishmentAddress().getCountry())
                .zipcode(String.valueOf(dto.getEstablishmentAddress().getZipcode()))
                .build() : null)
        .establishmentServices(
            dto.getEstablishmentServices() != null ? EstablishmentServices.builder()
                .serviceName(dto.getEstablishmentServices().getName())
                .serviceType(EstablishmentServiceType.valueOf(dto.getEstablishmentServices().getType()))
                .build() : null)
        .build();
  }

  public static EstablishmentDTO fromEntity(Establishments entity) {
    return EstablishmentDTO.builder()
        .establishmentId(entity.getEstablishmentId())
        .sessionId(entity.getSessionId())
        .establishmentDetails(fromDetails(entity.getEstablishmentDetails()))
        .establishmentMetaData(fromMetadata(entity.getEstablishmentMetaData()))
        .createdAt(entity.getCreatedAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
  }



  private static EstablishmentDetailsDTO fromDetails(EstablishmentDetails entity) {
    if (entity == null) return null;

    return EstablishmentDetailsDTO.builder()
        .establishmentPhotoIds(entity.getEstablishmentPhotoIds())
        .establishmentAddressId(entity.getEstablishmentAddressId())
        .establishmentPaymentModeIds(entity.getEstablishmentPaymentModeIds())
        .establishmentRegistrationFees(entity.getEstablishmentRegistrationFees())
        .establishmentInsuranceProviderIds(entity.getEstablishmentInsuranceProviderIds())
        .establishmentDescription(entity.getEstablishmentDescription())
        .establishmentOwnershipVerified(entity.isEstablishmentOwnershipVerified())
        .build();
  }

  private static EstablishmentMetaDataDTO fromMetadata(EstablishmentMetaData entity) {
    if (entity == null) return null;

    return EstablishmentMetaDataDTO.builder()
        .establishmentPhoto(entity.getEstablishmentPhotos() != null ?
            EstablishmentPhotoDTO.builder()
                .type(entity.getEstablishmentPhotos().getEstablishmentPhotoType().name())
                .url(entity.getEstablishmentPhotos().getPhotoUrl())
                .build() : null)
        .establishmentAddress(entity.getEstablishmentAddress() != null ?
            EstablishmentAddressDTO.builder()
                .addressLine(entity.getEstablishmentAddress().getAddressLine())
                .landmark(entity.getEstablishmentAddress().getLandmark())
                .locality(entity.getEstablishmentAddress().getLocality())
                .city(entity.getEstablishmentAddress().getCity())
                .country(entity.getEstablishmentAddress().getCountry())
                .zipcode(Integer.parseInt(entity.getEstablishmentAddress().getZipcode()))
                .build() : null)
        .establishmentServices(entity.getEstablishmentServices() != null ?
            EstablishmentServiceDTO.builder()
                .type(entity.getEstablishmentServices().getServiceType().name())
                .name(entity.getEstablishmentServices().getServiceName())
                .build() : null)
        .build();

  }
}
