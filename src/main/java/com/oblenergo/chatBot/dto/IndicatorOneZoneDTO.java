package com.oblenergo.chatBot.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndicatorOneZoneDTO implements Serializable {

  private static final long serialVersionUID = -7178779695229018079L;
  
  @NotBlank(message="Не може бути пустим")
  @Pattern(regexp="\\d+", message="Дозволено тільки цифри")
  private String indicator;

  public String getIndicator() {
    return indicator;
  }

  public void setIndicator(String indicator) {
    this.indicator = indicator;
  }
  
  

}
