package com.oblenergo.chatBot.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndicatorResponseDTO implements Serializable {

  private static final long serialVersionUID = 490334213732184514L;
  
  private String answer;

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
  
  
  
  

}
