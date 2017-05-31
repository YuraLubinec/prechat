package com.oblenergo.chatBot.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndicatorThreeZoneDTO implements Serializable {

  private static final long serialVersionUID = -2474510251196774785L;

  @NotBlank(message = "Не може бути пустим")
  @Pattern(regexp = "\\d+", message = "Дозволено тільки цифри")
  private String peakIndicator;

  @NotBlank(message = "Не може бути пустим")
  @Pattern(regexp = "\\d+", message = "Дозволено тільки цифри")
  private String halfPeakIndicator;

  @NotBlank(message = "Не може бути пустим")
  @Pattern(regexp = "\\d+", message = "Дозволено тільки цифри")
  private String nightIndicator;
  
}
