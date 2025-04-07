package com.practo.ultron.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "payment_modes")
public class PaymentModes {

  @Id
  private String paymentModeId;

  private String paymentMode;

  public PaymentModes(String paymentMode) {
    this.paymentModeId = UUID.randomUUID().toString();
    this.paymentMode = paymentMode;
  }
}
