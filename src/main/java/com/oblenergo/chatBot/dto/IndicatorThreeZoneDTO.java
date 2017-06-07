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

  @NotBlank
  @Pattern(regexp = "\\d+")
  private String peakIndicator;

  @NotBlank
  @Pattern(regexp = "\\d+")
  private String halfPeakIndicator;

  @NotBlank
  @Pattern(regexp = "\\d+")
  private String nightIndicator;
  
}
