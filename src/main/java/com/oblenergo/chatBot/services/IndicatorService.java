package com.oblenergo.chatBot.services;

import org.springframework.http.ResponseEntity;

import com.oblenergo.chatBot.dto.IndicatorDTO;

public interface IndicatorService {
  
  ResponseEntity<String> saveIndicator(IndicatorDTO indicator);

}
