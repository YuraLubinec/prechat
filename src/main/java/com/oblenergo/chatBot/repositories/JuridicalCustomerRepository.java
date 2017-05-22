package com.oblenergo.chatBot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.chatBot.models.JuridicalCustomer;

public interface JuridicalCustomerRepository extends JpaRepository<JuridicalCustomer, Long> {
  
  @Transactional(readOnly=true)
  JuridicalCustomer findByContractNumberAndCounterNumber(String contractNumber, String counterNumber);

}
