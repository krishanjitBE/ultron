package com.practo.ultron.api.controller;

import com.practo.ultron.api.DTO.*;
import com.practo.ultron.api.httpResponse.EstablishmentHTTPResponse;
import com.practo.ultron.api.service.*;
import com.practo.ultron.api.util.WebConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping(WebConstants.Routes.API + WebConstants.Routes.SEPARATOR + WebConstants.Routes.V1 +
    WebConstants.Routes.SEPARATOR + WebConstants.Routes.ESTABLISHMENT)
public class EstablishmentController {

  @Autowired
  private EstablishmentService establishmentService;


  @PostMapping("/create")
  public EstablishmentHTTPResponse postEstablishmentData(
      @RequestBody EstablishmentDTO establishmentDTO) {
    log.info("Establishment creation request received.");
    return establishmentService.postData(establishmentDTO);
  }

  @GetMapping("/{establishmentId}")
  public EstablishmentDTO getEstablishmentPhoto(
      @PathVariable String establishmentId) throws Exception {
    log.info("Establishment GET request received for ID: {}", establishmentId);
    return establishmentService.getData(establishmentId);
  }
}
