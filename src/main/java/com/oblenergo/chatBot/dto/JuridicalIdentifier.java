package com.oblenergo.chatBot.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JuridicalIdentifier implements Serializable {

  private static final long serialVersionUID = 1194424216574565686L;
  
  @NotBlank
  @Pattern(regexp = "([(\\w)а-яА-я]+(\\/?))+", message="some.message")
  private String contractNumber;
  
  @NotBlank
  @Pattern(regexp = "\\d+")
  private String counterNumber;
  
}
