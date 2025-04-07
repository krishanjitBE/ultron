package com.practo.ultron.api.controller;

import com.practo.ultron.api.DTO.*;
import com.practo.ultron.api.model.EstablishmentPhotos;
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


  @Autowired
  EstablishmentPhotoService establishmentPhotoService;

  @Autowired
  EstablishmentAddressService establishmentAddressService;

  @Autowired
  EstablishmentServicesService establishmentServicesService;

  @Autowired
  EstablishmentDetailsService establishmentDetailsService;

  @PostMapping("/create")
  public boolean postEstablishmentData(
      @RequestBody EstablishmentCreateRequestDTO establishmentCreateRequestDTO) {
    log.info("Establishment creation request received.");
    return establishmentService.postEstablishmentData(establishmentCreateRequestDTO);
  }

  @PostMapping("/photo/create")
  public boolean postEstablishmentPhoto(
      @RequestBody EstablishmentPhotoCreateRequestDTO requestDTO) {
    log.info("Establishment photo create request received");
    return establishmentPhotoService.postEstablishmentPhoto(requestDTO);
  }

  @GetMapping("/photo/{photoId}")
  public EstablishmentPhotos getEstablishmentPhoto(@PathVariable String photoId) {
    log.info("Establishment photo GET request received for ID: {}", photoId);
    return establishmentPhotoService.getEstablishmentPhotoById(photoId);
  }

  @PostMapping("/address/create")
  public boolean postEstablishmentAddress(
      @RequestBody EstablishmentAddressCreateRequestDTO requestDTO) {
    log.info("Establishment address create request received");
    return establishmentAddressService.postEstablishmentAddress(requestDTO);
  }

  @PostMapping("/services/create")
  public boolean postEstablishmentServices(
      @RequestBody EstablishmentServiceCreateRequestDTO requestDTO) {
    log.info("Establishment address create request received");
    return establishmentServicesService.postEstablishmentServices(requestDTO);
  }

  @PostMapping("/details/create")
  public boolean postEstablishmentDetails(
      @RequestBody EstablishmentDetailsCreateRequestDTO requestDTO) {
    log.info("Establishment address create request received");
    return establishmentDetailsService.postEstablishmentDetails(requestDTO);
  }
}
