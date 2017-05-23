package com.oblenergo.chatBot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oblenergo.chatBot.dto.IndicatorDTO;
import com.oblenergo.chatBot.dto.IndicatorOneZoneDTO;
import com.oblenergo.chatBot.dto.IndicatorThreeZoneDTO;
import com.oblenergo.chatBot.dto.IndicatorTwoZoneDTO;
import com.oblenergo.chatBot.models.Bill;
import com.oblenergo.chatBot.models.PhysCustomer;
import com.oblenergo.chatBot.models.TurnOffReportPhys;
import com.oblenergo.chatBot.repositories.PhysCustomerRepository;
import com.oblenergo.chatBot.repositories.TurnOffreportPhysRepository;
import com.oblenergo.chatBot.services.IndicatorService;

@RestController
@RequestMapping("/customer/physical/{accountNumber}")
public class PhysicalCustomerController {

  @Autowired
  private PhysCustomerRepository physCustomerRepository;

  @Autowired
  private TurnOffreportPhysRepository turnOffreportPhysRepository;

  @Autowired
  private IndicatorService indicatorService;

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

  @PostMapping("/indicator/onezone")
  public ResponseEntity<String> saveIndicatorForOneZoneCounter(@PathVariable String accountNumber,
      @Validated @RequestBody IndicatorOneZoneDTO oneZoneDTO, BindingResult result) {
   
    if (result.hasErrors()) {
      String message = result.getAllErrors().get(0).getDefaultMessage();
      return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }
    IndicatorDTO indicatorDTO = new IndicatorDTO();
    indicatorDTO.setAccountNumber(accountNumber);
    indicatorDTO.setCounterValue(oneZoneDTO.getIndicator());
    indicatorDTO.setPhoneNumber("0964455666");
    return indicatorService.saveIndicator(indicatorDTO);
  }

  @PostMapping("/indicator/twozone")
  public ResponseEntity<String> saveIndicatorForTwoZoneCounter(@PathVariable String accountNumber,
      @Validated @RequestBody IndicatorTwoZoneDTO twoZoneDTO, BindingResult result) {
   
    if (result.hasErrors()) {
      String message = result.getAllErrors().get(0).getDefaultMessage();
      return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }
    IndicatorDTO indicatorDTO = new IndicatorDTO();
    indicatorDTO.setAccountNumber(accountNumber);
    indicatorDTO.setCounterValue(twoZoneDTO.getDayIndicator() + "/" + twoZoneDTO.getNightIndicator());
    indicatorDTO.setPhoneNumber("0964455666");
    return indicatorService.saveIndicator(indicatorDTO);
  }

  @PostMapping("/indicator/threezone")
  public ResponseEntity<String> saveIndicatorForThreeZoneCounter(@PathVariable String accountNumber,
      @Validated @RequestBody IndicatorThreeZoneDTO threeZoneDTO, BindingResult result) {

    if (result.hasErrors()) {
      String message = result.getAllErrors().get(0).getDefaultMessage();
      return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }
    IndicatorDTO indicatorDTO = new IndicatorDTO();
    indicatorDTO.setAccountNumber(accountNumber);
    indicatorDTO.setCounterValue(threeZoneDTO.getPeakIndicator() + "/" + threeZoneDTO.getHalfPeakIndicator() + "/"
        + threeZoneDTO.getNightIndicator());
    indicatorDTO.setPhoneNumber("0964455666");
    return indicatorService.saveIndicator(indicatorDTO);
  }

}