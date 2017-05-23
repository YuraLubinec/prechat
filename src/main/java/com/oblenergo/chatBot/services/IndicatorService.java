package com.oblenergo.chatBot.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.oblenergo.chatBot.dto.IndicatorDTO;
import com.oblenergo.chatBot.dto.IndicatorResponseDTO;

@Service
public class IndicatorService {

  Logger LOGGER = Logger.getLogger(IndicatorService.class);

  @Value("${indicator.service.url}")
  private String url;

  private final static String DEFAULTFAILUREMESSAGE = "Сервіс недоступний, спробуйте пізніше";

  public ResponseEntity<String> saveIndicator(IndicatorDTO indicator) {

    RestTemplate template = new RestTemplate();
    HttpEntity<IndicatorDTO> request = new HttpEntity<>(indicator);
    try {
      return new ResponseEntity<String>(
          template.exchange(url, HttpMethod.POST, request, IndicatorResponseDTO.class).getBody().getAnswer(),
          HttpStatus.OK);
    } catch (HttpStatusCodeException ex) {
      LOGGER.error(ex.getStatusCode().value(), ex);
      return new ResponseEntity<String>(DEFAULTFAILUREMESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (RestClientException ex) {
      LOGGER.error(ex);
      return new ResponseEntity<String>(DEFAULTFAILUREMESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
