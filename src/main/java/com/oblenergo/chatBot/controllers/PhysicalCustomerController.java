package com.oblenergo.chatBot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oblenergo.chatBot.models.Bill;
import com.oblenergo.chatBot.models.PhysCustomer;
import com.oblenergo.chatBot.models.TurnOffReportPhys;
import com.oblenergo.chatBot.repositories.PhysCustomerRepository;
import com.oblenergo.chatBot.repositories.TurnOffreportPhysRepository;

@RestController
@RequestMapping("/customer/physical/{accountNumber}")
public class PhysicalCustomerController {

  @Autowired
  private PhysCustomerRepository physCustomerRepository;

  @Autowired
  private TurnOffreportPhysRepository turnOffreportPhysRepository;

  @GetMapping
  public PhysCustomer checkId(@PathVariable String accountNumber) {
    PhysCustomer customer = physCustomerRepository.findByAccountNumber(accountNumber);
    return customer != null ? customer : null;
  }

  @GetMapping("/report")
  public TurnOffReportPhys getEnergyReport(@PathVariable String accountNumber) {
    TurnOffReportPhys turnOffReportPhys = turnOffreportPhysRepository.findByAccountNumber(accountNumber);
    return turnOffReportPhys != null ? turnOffReportPhys : null;
  }

  @GetMapping("/bill")
  public Bill getBillForPhysicalCustomer(@PathVariable String accountNumber) {
    return new Bill("test account" + accountNumber, "srako-test");
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/indicator/onezone")
  public void saveIndicatorForOneZoneCounter(@PathVariable String accountNumber) {
    System.out.println(physCustomerRepository.findByAccountNumber(accountNumber));

  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/indicator/twozone")
  public void saveIndicatorForTwoZoneCounter(@PathVariable String accountNumber) {
    System.out.println(physCustomerRepository.findByAccountNumber(accountNumber));
  }

}
