package com.oblenergo.chatBot.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oblenergo.chatBot.dto.IndicatorDTO;
import com.oblenergo.chatBot.dto.IndicatorResponseDTO;

@Service
public class IndicatorServiceImpl implements IndicatorService {

  @Value("${indicator.service.url}")
  private String url;

  @Override
  public ResponseEntity<String> saveIndicator(IndicatorDTO indicator) {

    RestTemplate template = new RestTemplate();
    HttpEntity<IndicatorDTO> request = new HttpEntity<>(indicator);
    return new ResponseEntity<String>(
        template.exchange(url, HttpMethod.POST, request, IndicatorResponseDTO.class).getBody().getAnswer(),
        HttpStatus.OK);
  }
}
