package com.practo.ultron.api.service;

import com.practo.ultron.api.DTO.EstablishmentPhotoCreateRequestDTO;
import com.practo.ultron.api.model.EstablishmentPhotos;

public interface EstablishmentPhotoService {

  public boolean postEstablishmentPhoto(EstablishmentPhotoCreateRequestDTO dto);

  EstablishmentPhotos getEstablishmentPhotoById(String photoId);

}
