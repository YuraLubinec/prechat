package com.oblenergo.chatBot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.chatBot.models.TurnOffReportPhys;

public interface TurnOffreportPhysRepository extends JpaRepository<TurnOffReportPhys, Long> {
  
  @Transactional(readOnly=true)
  TurnOffReportPhys findByAccountNumber(String accountNumber);

}
