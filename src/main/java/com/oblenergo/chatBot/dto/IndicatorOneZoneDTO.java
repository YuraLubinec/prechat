package com.oblenergo.chatBot.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndicatorOneZoneDTO implements Serializable {

  private static final long serialVersionUID = -7178779695229018079L;
  
  @NotBlank
  @Pattern(regexp="\\d+")
  private String indicator;

}
