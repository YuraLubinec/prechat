package com.oblenergo.chatBot.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.oblenergo.chatBot.enums.Reasons;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BillServiceImpl implements BillService {

  private static final String REGEXPATTERN = "amountToPay=\"[+-]?(\\d+)([\\.]?)(\\d*)";
  private static final String DEFAULTFAILUREMESSAGE = "Сервіс недоступний, спробуйте пізніше";
  private static final int LENTH_TO_TRIM = 13;

  @Autowired
  private StatisticService statisticService;

  @Value("${bill.service.url}")
  private String url;

  @Value("${xmlToSendFirstPart}")
  private String xmlToSendFirstPart;

  @Value("${xmlToSendSecondPart}")
  private String xmlToSendSecondPart;

  @Override
  public ResponseEntity<String> getBill(String accountNumber) {

    RestTemplate template = new RestTemplate();
    HttpEntity<String> request = new HttpEntity<String>(xmlToSendFirstPart + accountNumber + xmlToSendSecondPart);
    statisticService.saveStatisticForPhysCustomer(accountNumber, Reasons.BILL);
    try {
      return new ResponseEntity<String>(parseResponse(template.postForObject(url, request, String.class)), HttpStatus.OK);
    } catch (RestClientException e) {
      log.error("Error occurred with bill service " + e);
      return new ResponseEntity<String>(DEFAULTFAILUREMESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  private String parseResponse(String response) {

    Pattern p = Pattern.compile(REGEXPATTERN);
    Matcher m = p.matcher(response);
    String token = null;
    while (m.find()) {
      token = m.group().substring(LENTH_TO_TRIM);
    }
    return token;
  }

}
