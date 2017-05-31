package com.oblenergo.chatBot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;

import lombok.extern.log4j.Log4j;

@Log4j
@RestControllerAdvice
public class GeneralController {

  private final static String DEFAULTFAILUREMESSAGE = "Сервіс недоступний, спробуйте пізніше";

  @ExceptionHandler(HttpStatusCodeException.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = DEFAULTFAILUREMESSAGE)
  public void errorHttpStatus(HttpStatusCodeException e) {
   
    log.error("Error occurred with indicator service"+e.getStatusCode().value(), e);
  }
  
  @ExceptionHandler(RestClientException.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = DEFAULTFAILUREMESSAGE)
  public void errorRestClient(RestClientException e) {
   
    log.error("Error occurred with indicator service", e);
  }
  
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
  public void errorMethodNotSupported(Exception e) {
   
    log.error("Method isn`t supported", e);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = DEFAULTFAILUREMESSAGE)
  public void error500Default(Exception e) {
   
    log.error("Server error occurred", e);
  }
  
  
  
  
  

}
