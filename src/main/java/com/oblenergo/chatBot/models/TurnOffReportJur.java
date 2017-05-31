package com.oblenergo.chatBot.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "dbo.JuridicalCustomerturnOffInfo")
public class TurnOffReportJur implements Serializable {

  private static final long serialVersionUID = -8183848564150608327L;

  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "contractNumber")
  private String contractNumber;
  @Column(name = "counterNumber")
  private String counterNumber;
  @Column(name = "beginTurnOff")
  private String beginTurnOff;
  @Column(name = "endTurnOff")
  private String endTurnOff;

}
