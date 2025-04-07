package com.practo.ultron.api.service;

import com.practo.ultron.api.DTO.EstablishmentPhotoCreateRequestDTO;
import com.practo.ultron.api.enums.EstablishmentPhotoType;
import com.practo.ultron.api.model.EstablishmentPhotos;
import com.practo.ultron.api.repository.EstablishmentPhotoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class EstablishmentPhotoServiceImpl implements EstablishmentPhotoService {

  @Autowired
  private EstablishmentPhotoRepository establishmentPhotoRepository;

  @Override
  public boolean postEstablishmentPhoto(EstablishmentPhotoCreateRequestDTO dto) {
    String photoType = dto.getPhotoType().toUpperCase();
    EstablishmentPhotos photos = EstablishmentPhotos.builder()
        .establishmentPhotoType(EstablishmentPhotoType.valueOf(photoType))
        .photoUrl(dto.getPhotoUrl())
        .build();


    try {
      establishmentPhotoRepository.save(photos);
      return true;
    } catch (Exception e) {
      throw new RuntimeException(e);

    }
  }

  @Override
  public EstablishmentPhotos getEstablishmentPhotoById(String photoId) {
    log.info("Fetching establishment photo with ID: {}", photoId);
    return establishmentPhotoRepository.findById(photoId)
        .orElseThrow(() -> new RuntimeException("Establishment photo not found with ID: " + photoId));
  }
}
