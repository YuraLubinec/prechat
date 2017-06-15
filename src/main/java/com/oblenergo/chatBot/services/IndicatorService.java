package com.oblenergo.chatBot.services;

import org.springframework.http.ResponseEntity;

import com.oblenergo.chatBot.dto.IndicatorOneZoneDTO;
import com.oblenergo.chatBot.dto.IndicatorThreeZoneDTO;
import com.oblenergo.chatBot.dto.IndicatorTwoZoneDTO;

public interface IndicatorService {

  ResponseEntity<String> saveOneZoneIndicator(IndicatorOneZoneDTO oneZoneDTO, String accountNumber);

  ResponseEntity<String> saveTwoZoneIndicator(IndicatorTwoZoneDTO twoZoneDTO, String accountNumber);

  ResponseEntity<String> saveThreeZoneIndicator(IndicatorThreeZoneDTO threeZoneDTO, String accountNumber);

}
