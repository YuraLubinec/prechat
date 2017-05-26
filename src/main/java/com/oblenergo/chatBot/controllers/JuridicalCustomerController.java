package com.oblenergo.chatBot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oblenergo.chatBot.enums.Reasons;
import com.oblenergo.chatBot.models.JuridicalCustomer;
import com.oblenergo.chatBot.models.TurnOffReportJur;
import com.oblenergo.chatBot.repositories.JuridicalCustomerRepository;
import com.oblenergo.chatBot.repositories.TurnOffReportJurRepository;
import com.oblenergo.chatBot.services.StatisticService;

@RestController
@RequestMapping("/customer/juridical/{contractNumber}/{counterNumber}")
public class JuridicalCustomerController {

  @Autowired
  private TurnOffReportJurRepository juReportJurRepository;

  @Autowired
  private JuridicalCustomerRepository juridicalCustomerRepository;
  
  @Autowired
  private StatisticService statisticService;

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
    statisticService.saveStatisticForJurCustomer(contractNumber, counterNumber, Reasons.NO_ENERGY_REPORT_JUR);
    return turnOffReportJur != null ? turnOffReportJur : null;
  }
  
}
