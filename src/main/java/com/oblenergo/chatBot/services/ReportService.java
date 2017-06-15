package com.oblenergo.chatBot.services;

import java.util.List;

import com.oblenergo.chatBot.dto.TurnOffReportDTO;

public interface ReportService {
  
  TurnOffReportDTO getTurnOffReportPhys(String accountNumber);
  
  List<TurnOffReportDTO> getTurnOffReportjJur(String contractNumber);
}
