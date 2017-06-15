package com.oblenergo.chatBot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oblenergo.chatBot.dto.JuridicalIdentifier;
import com.oblenergo.chatBot.dto.TurnOffReportDTO;
import com.oblenergo.chatBot.models.JuridicalCustomer;
import com.oblenergo.chatBot.repositories.JuridicalCustomerRepository;
import com.oblenergo.chatBot.services.ReportService;

@RestController
@RequestMapping("/customer/juridical")
public class JuridicalCustomerController {

  @Autowired
  private JuridicalCustomerRepository juridicalCustomerRepository;
  
  @Autowired
  private ReportService reportService;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public JuridicalCustomer JuridicalCustomercheckContractNumber(@Validated @RequestBody JuridicalIdentifier identifier) {
 
    return juridicalCustomerRepository.findTopByContractNumber(identifier.getContractNumber());
  }

  @PostMapping("/report")
  @ResponseStatus(HttpStatus.OK)
  public List<TurnOffReportDTO> getEnergyReport(@Validated @RequestBody JuridicalIdentifier identifier) {

    return reportService.getTurnOffReportjJur(identifier.getContractNumber());
  }

}
