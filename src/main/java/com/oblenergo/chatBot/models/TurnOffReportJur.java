package com.oblenergo.chatBot.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContractNumber() {
    return contractNumber;
  }

  public void setContractNumber(String contractNumber) {
    this.contractNumber = contractNumber;
  }

  public String getCounterNumber() {
    return counterNumber;
  }

  public void setCounterNumber(String counterNumber) {
    this.counterNumber = counterNumber;
  }

  public String getBeginTurnOff() {
    return beginTurnOff;
  }

  public void setBeginTurnOff(String beginTurnOff) {
    this.beginTurnOff = beginTurnOff;
  }

  public String getEndTurnOff() {
    return endTurnOff;
  }

  public void setEndTurnOff(String endTurnOff) {
    this.endTurnOff = endTurnOff;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this, true);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj, true);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
