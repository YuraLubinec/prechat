package com.oblenergo.chatBot.services;

import org.springframework.http.ResponseEntity;

public interface BillService {
  
  ResponseEntity<String> getBill(String accountNumber);

}
