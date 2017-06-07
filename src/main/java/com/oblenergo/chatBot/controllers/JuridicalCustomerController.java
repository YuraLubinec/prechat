package com.oblenergo.chatBot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oblenergo.chatBot.dto.JuridicalIdentifier;
import com.oblenergo.chatBot.enums.Reasons;
import com.oblenergo.chatBot.models.JuridicalCustomer;
import com.oblenergo.chatBot.models.TurnOffReportJur;
import com.oblenergo.chatBot.repositories.JuridicalCustomerRepository;
import com.oblenergo.chatBot.repositories.TurnOffReportJurRepository;
import com.oblenergo.chatBot.services.StatisticService;

@RestController
@RequestMapping("/customer/juridical")
public class JuridicalCustomerController {

  @Autowired
  private TurnOffReportJurRepository juReportJurRepository;

  @Autowired
  private JuridicalCustomerRepository juridicalCustomerRepository;

  @Autowired
  private StatisticService statisticService;

  @PostMapping
  public ResponseEntity<?> JuridicalCustomercheckContractNumber(@Validated @RequestBody JuridicalIdentifier identifier, BindingResult result) {

    if (result.hasErrors()) {
      String message = result.getAllErrors().get(0).getDefaultMessage();
      return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<JuridicalCustomer>(
        juridicalCustomerRepository.findByContractNumberAndCounterNumber(identifier.getContractNumber(), identifier.getCounterNumber()), HttpStatus.OK);
  }

  @PostMapping("/report")
  public ResponseEntity<?> getEnergyReport(@Validated @RequestBody JuridicalIdentifier identifier, BindingResult result) {

    if (result.hasErrors()) {
      String message = result.getAllErrors().get(0).getDefaultMessage();
      return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }
    String contractNumber = identifier.getContractNumber();
    String counterNumber = identifier.getCounterNumber();
    statisticService.saveStatisticForJurCustomer(contractNumber, counterNumber, Reasons.NOENERGYREPORTJUR);
    return new ResponseEntity<TurnOffReportJur>(juReportJurRepository.findByContractNumberAndCounterNumber(contractNumber, counterNumber), HttpStatus.OK);
  }

}
