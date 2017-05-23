package com.oblenergo.chatBot.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndicatorTwoZoneDTO implements Serializable {

  private static final long serialVersionUID = 411358646302415484L;

  @NotBlank(message = "Не може бути пустим")
  @Pattern(regexp = "\\d+", message = "Дозволено тільки цифри")
  private String dayIndicator;

  @NotBlank(message = "Не може бути пустим")
  @Pattern(regexp = "\\d+", message = "Дозволено тільки цифри")
  private String nightIndicator;

  public String getDayIndicator() {
    return dayIndicator;
  }

  public void setDayIndicator(String dayIndicator) {
    this.dayIndicator = dayIndicator;
  }

  public String getNightIndicator() {
    return nightIndicator;
  }

  public void setNightIndicator(String nightIndicator) {
    this.nightIndicator = nightIndicator;
  }

}
