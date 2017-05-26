package com.oblenergo.chatBot.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.oblenergo.chatBot.enums.Reasons;

@Entity
@Table(name = "dbo.chatbotStatistic")
public class Statistic implements Serializable {

  private static final long serialVersionUID = -3653936311706121639L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "date")
  private String date;
  @Column(name = "reason")
  @Enumerated(EnumType.STRING)
  private Reasons reason;
  @Column(name = "accountNumber")
  private String accountNumber;
  @Column(name = "contractNumber")
  private String contractNumber;
  @Column(name = "counterNumber")
  private String counterNumber;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Reasons getReason() {
    return reason;
  }

  public void setReason(Reasons reason) {
    this.reason = reason;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
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
