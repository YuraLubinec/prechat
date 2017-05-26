package com.oblenergo.chatBot.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.oblenergo.chatBot.enums.Reasons;
import com.oblenergo.chatBot.models.Statistic;
import com.oblenergo.chatBot.repositories.JuridicalCustomerRepository;
import com.oblenergo.chatBot.repositories.PhysCustomerRepository;
import com.oblenergo.chatBot.repositories.StatisticRepository;

@Service
@Transactional
public class StatisticService {
  
  @Autowired
  private StatisticRepository statisticRepository;
  
  @Autowired
  private JuridicalCustomerRepository juridicalCustomerRepository;
  
  @Autowired
  private PhysCustomerRepository physCustomerRepository;
  
  @Async
  public void saveStatisticForPhysCustomer(String accountNumber, Reasons reason){

    Statistic statistic = new Statistic();
    statistic.setDate(LocalDateTime.now().toString());
    statistic.setAccountNumber(accountNumber);
    statistic.setReason(reason);
    if (physCustomerRepository.findByAccountNumber(accountNumber) != null){
      statisticRepository.save(statistic);
    }
  }
  
  @Async
  public void saveStatisticForJurCustomer(String contractNumber, String counterNumber, Reasons reason){

    Statistic statistic = new Statistic();
    statistic.setDate(LocalDateTime.now().toString());
    statistic.setContractNumber(contractNumber);
    statistic.setCounterNumber(counterNumber);
    statistic.setReason(reason);
    if(juridicalCustomerRepository.findByContractNumberAndCounterNumber(contractNumber, counterNumber) != null){
      statisticRepository.save(statistic);
    }
  }

}
