package com.oblenergo.chatBot.services;

import static com.oblenergo.chatBot.enums.Scenario.EMERGENCY_WORK;
import static com.oblenergo.chatBot.enums.Scenario.PLANNED_WORK;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oblenergo.chatBot.dto.TurnOffReportDTO;
import com.oblenergo.chatBot.enums.Reasons;
import com.oblenergo.chatBot.models.TurnOffReportJur;
import com.oblenergo.chatBot.models.TurnOffReportPhys;
import com.oblenergo.chatBot.repositories.TurnOffReportJurRepository;
import com.oblenergo.chatBot.repositories.TurnOffReportPhysRepository;

@Service
public class ReportServiceImpl implements ReportService {

  private static final int SEC_LENGTH = 5;
  private static final int WORK_ID_1 = 1;
  private static final int WORK_ID_2 = 20;

  @Autowired
  private TurnOffReportPhysRepository turnOffreportPhysRepository;

  @Autowired
  private StatisticService statisticService;

  @Autowired
  private TurnOffReportJurRepository turnOffReportJurRepository;

  @Override
  public TurnOffReportDTO getTurnOffReportPhys(String accountNumber) {

    TurnOffReportDTO turnOffReportPhysDTO = null;
    TurnOffReportPhys turnOffReportPhys = turnOffreportPhysRepository.findTopByAccountNumber(accountNumber);
    if (turnOffReportPhys != null) {
      turnOffReportPhysDTO = new TurnOffReportDTO();
      turnOffReportPhysDTO.setScenario(getScenarioName(turnOffReportPhys.getScenarioId()));
      turnOffReportPhysDTO.setFullAddress(turnOffReportPhys.getFullAddress());
      turnOffReportPhysDTO.setEndTurnOff(stripSeconds(turnOffReportPhys.getEndTurnOff()));

    }
    statisticService.saveStatisticForPhysCustomer(accountNumber, Reasons.NOENERGYREPORTPHYS);
    return turnOffReportPhysDTO;
  }

  @Override
  public List<TurnOffReportDTO> getTurnOffReportjJur(String contractNumber) {

    List<TurnOffReportDTO> turnOffReportDTOList = null;
    List<TurnOffReportJur> turnOffReportJurList = turnOffReportJurRepository.findByContractNumber(contractNumber);

    if (!turnOffReportJurList.isEmpty()) {
      turnOffReportDTOList = turnOffReportJurList.stream().map(turnOffReportJur -> {
        TurnOffReportDTO turnOffReportDTO = new TurnOffReportDTO();
        turnOffReportDTO.setScenario(getScenarioName(turnOffReportJur.getScenarioId()));
        turnOffReportDTO.setFullAddress(turnOffReportJur.getFullAddress());
        turnOffReportDTO.setEndTurnOff(stripSeconds(turnOffReportJur.getEndTurnOff()));
        return turnOffReportDTO;
      }).collect(Collectors.toList());
    
    }

    statisticService.saveStatisticForJurCustomer(contractNumber, Reasons.NOENERGYREPORTJUR);
    return turnOffReportDTOList;
  }

  private String getScenarioName(int scenarioId) {

    String scenarioName = EMERGENCY_WORK.getScenarioName();
    if (scenarioId == WORK_ID_1 || scenarioId == WORK_ID_2) {
      scenarioName = PLANNED_WORK.getScenarioName();
    }
    return scenarioName;
  }

  private String stripSeconds(String endTurnOff) {

    return endTurnOff.substring(0, endTurnOff.length() - SEC_LENGTH);
  }

}
