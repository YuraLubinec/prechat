package com.oblenergo.chatBot.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BillService {
  
  private static final String REGEXPATTERN = "amountToPay=\"[+-]?\\d+";

  @Value("${bill.service.url}")
  private String url;

  @Value("${xmlToSendFirstPart}")
  private String xmlToSendFirstPart;

  @Value("${xmlToSendSecondPart}")
  private String xmlToSendSecondPart;

  public ResponseEntity<String> getBill(String accountNumber) {
    RestTemplate template = new RestTemplate();
    HttpEntity<String> request = new HttpEntity<String>(xmlToSendFirstPart + accountNumber + xmlToSendSecondPart);
    return new ResponseEntity<String>(parseResponse(template.postForObject(url, request, String.class)), HttpStatus.OK);
  }
  
  private String parseResponse(String response){
    Pattern p = Pattern.compile(REGEXPATTERN);
    Matcher m = p.matcher(response);
    String token = null;
    while (m.find()) {
      token=m.group().substring(13);
    }
    return token;
  }

}
