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
@Table(name = "dbo.PhysicalCustomerturnOffInfo")
public class TurnOffReportPhys implements Serializable {

  private static final long serialVersionUID = 7897348277407699052L;

  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "accountNumber")
  private String accountNumber;
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

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
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
