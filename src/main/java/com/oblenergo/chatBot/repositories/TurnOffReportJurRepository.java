package com.oblenergo.chatBot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.chatBot.models.TurnOffReportJur;
import com.oblenergo.chatBot.models.TurnOffReportJurPK;

public interface TurnOffReportJurRepository extends JpaRepository<TurnOffReportJur, TurnOffReportJurPK>{
  
  @Transactional(readOnly=true)
  List <TurnOffReportJur> findByContractNumber(String contractNumber);

}
