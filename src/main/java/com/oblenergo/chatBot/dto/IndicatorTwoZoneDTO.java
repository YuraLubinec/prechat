package com.oblenergo.chatBot.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndicatorTwoZoneDTO implements Serializable {

  private static final long serialVersionUID = 411358646302415484L;

  @NotBlank
  @Pattern(regexp = "\\d+")
  private String dayIndicator;

  @NotBlank(message = "Не може бути пустим")
  @Pattern(regexp = "\\d+")
  private String nightIndicator;

}
