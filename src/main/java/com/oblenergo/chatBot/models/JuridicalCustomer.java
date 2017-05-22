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
@Table(name = "billing.JurPersonBind")
public class JuridicalCustomer implements Serializable {

  private static final long serialVersionUID = -1524782270575742464L;

  @Id
  @Column(name = "id")
  private int id;
  @Column(name = "contractNumber")
  private String contractNumber;
  @Column(name = "counterNumber")
  private String counterNumber;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getContructNumber() {
    return contractNumber;
  }

  public void setContructNumber(String contractNumber) {
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
