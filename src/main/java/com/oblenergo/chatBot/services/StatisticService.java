package com.oblenergo.chatBot.services;

import com.oblenergo.chatBot.enums.Reasons;

public interface StatisticService {

  void saveStatisticForPhysCustomer(String accountNumber, Reasons reason);

  void saveStatisticForJurCustomer(String contractNumber, String counterNumber, Reasons reason);

}
