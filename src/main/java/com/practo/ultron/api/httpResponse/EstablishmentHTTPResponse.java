package com.practo.ultron.api.httpResponse;

public class EstablishmentHTTPResponse {

  private boolean success;
  private String message;
  private String sessionId;

  public EstablishmentHTTPResponse(boolean success, String message, String sessionId) {
    this.success = success;
    this.message = message;
    this.sessionId = sessionId;
  }

  public boolean isSuccess() { return success; }
  public String getMessage() { return message; }
  public String getSessionId() { return sessionId; }
}
