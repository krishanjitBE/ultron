package com.practo.ultron.api.service;

import com.practo.ultron.api.DTO.EstablishmentDTO;
import com.practo.ultron.api.httpResponse.EstablishmentHTTPResponse;

public interface EstablishmentService {

  EstablishmentHTTPResponse postData(EstablishmentDTO dto);

  EstablishmentDTO getData(String EstablishmentId) throws Exception;

}
