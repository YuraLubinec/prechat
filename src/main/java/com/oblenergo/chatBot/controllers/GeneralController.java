package com.oblenergo.chatBot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
  private final static String BADREQUESTMESSAGE = "Не вірний формат запиту";
  private final static String METHODNOTALLOWED = "Метод не підтримуєтсья";

  @ExceptionHandler(HttpStatusCodeException.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = DEFAULTFAILUREMESSAGE)
  public void errorHttpStatus(HttpStatusCodeException e) {

    log.error("Error occurred with indicator service" + e.getStatusCode().value(), e);
  }

  @ExceptionHandler(RestClientException.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = DEFAULTFAILUREMESSAGE)
  public void errorRestClient(RestClientException e) {

    log.error("Error occurred with indicator service", e);
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED, reason = METHODNOTALLOWED)
  public void errorMethodNotSupported(Exception e) {

    log.error("Method isn`t supported", e);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = BADREQUESTMESSAGE)
  public void errorHttpMessageNotReadable(HttpMessageNotReadableException e) {

    log.error("Error in http request syntax", e);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = DEFAULTFAILUREMESSAGE)
  public void error500Default(Exception e) {

    log.error("Server error occurred", e);
    throw new RuntimeException();
  }

}
