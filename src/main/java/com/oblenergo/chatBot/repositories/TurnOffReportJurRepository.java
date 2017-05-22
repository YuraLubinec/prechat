package com.oblenergo.chatBot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.chatBot.models.TurnOffReportJur;

public interface TurnOffReportJurRepository extends JpaRepository<TurnOffReportJur, Long>{
  
  @Transactional(readOnly=true)
  TurnOffReportJur findByContractNumberAndCounterNumber(String contractNumber, String counterNumber);

}
