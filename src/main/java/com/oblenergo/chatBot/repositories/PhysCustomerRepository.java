package com.oblenergo.chatBot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.chatBot.models.PhysCustomer;

public interface PhysCustomerRepository extends JpaRepository<PhysCustomer, Long>{
  
  @Transactional(readOnly=true)
  PhysCustomer findByAccountNumber(String accountNumber);

}
