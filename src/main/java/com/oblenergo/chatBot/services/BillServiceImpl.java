package com.oblenergo.chatBot.services;

import java.time.LocalDate;
import java.time.Month;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BillServiceImpl implements BillService {

  private static final String REGEXPATTERN = "amountToPay=\"[+-]?(\\d+)([\\.]?)(\\d*)";
  private static final int LENTH_TO_TRIM = 13;

  @Value("${bill.service.url}")
  private String url;

  @Value("${begin.period.date}")
  private int beginPeriodDate;

  @Value("${end.period.date}")
  private int endPeriodDate;

  @Value("${xmlToSendFirstPart}")
  private String xmlToSendFirstPart;

  @Value("${xmlToSendSecondPart}")
  private String xmlToSendSecondPart;

  @Override
  public ResponseEntity<String> getBill(String accountNumber) {

    if (checkPeriod()) {
      RestTemplate template = new RestTemplate();
      HttpEntity<String> request = new HttpEntity<String>(xmlToSendFirstPart + accountNumber + xmlToSendSecondPart);
      return new ResponseEntity<String>(parseResponse(template.postForObject(url, request, String.class)),
          HttpStatus.OK);
    }
    return new ResponseEntity<String>("Avaialble only from 20 to 3 of the month", HttpStatus.OK);
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

  private boolean checkPeriod() {

    LocalDate localDateNow = LocalDate.now();
    int month = localDateNow.getMonthValue();
    if (localDateNow.getMonth().equals(Month.DECEMBER)) {
      LocalDate endDateExclusive = LocalDate.of(localDateNow.getYear(), Month.JANUARY, endPeriodDate);
      LocalDate startDateInclusive = LocalDate.of(localDateNow.getYear(), month, beginPeriodDate);
      return localDateNow.isBefore(endDateExclusive) && localDateNow.isAfter(startDateInclusive);
    } else {
      LocalDate endDateExclusive = LocalDate.of(localDateNow.getYear(), month + 1, endPeriodDate);
      LocalDate startDateInclusive = LocalDate.of(localDateNow.getYear(), month, beginPeriodDate);
      return localDateNow.isBefore(endDateExclusive) && localDateNow.isAfter(startDateInclusive);
    }
  }

}
