package com.oblenergo.chatBot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oblenergo.chatBot.models.Bill;
import com.oblenergo.chatBot.models.JuridicalCustomer;
import com.oblenergo.chatBot.models.TurnOffReportJur;
import com.oblenergo.chatBot.repositories.JuridicalCustomerRepository;
import com.oblenergo.chatBot.repositories.TurnOffReportJurRepository;

@RestController
@RequestMapping("/customer/juridical/{contractNumber}/{counterNumber}")
public class JuridicalCustomerController {

  @Autowired
  private TurnOffReportJurRepository juReportJurRepository;

  @Autowired
  private JuridicalCustomerRepository juridicalCustomerRepository;

  @GetMapping
  public JuridicalCustomer checkContractNumber(@PathVariable String contractNumber,
      @PathVariable String counterNumber) {
    JuridicalCustomer juridicalCustomer = juridicalCustomerRepository
        .findByContractNumberAndCounterNumber(contractNumber, counterNumber);
    return juridicalCustomer != null ? juridicalCustomer : null;
  }
  
  @GetMapping("/report")
  public TurnOffReportJur getEnergyReport(@PathVariable String contractNumber,
      @PathVariable String counterNumber) {
    TurnOffReportJur turnOffReportJur =  juReportJurRepository.findByContractNumberAndCounterNumber(contractNumber, counterNumber);
    return turnOffReportJur != null ? turnOffReportJur : null;
  }
  
}
