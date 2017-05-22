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
@Table(name = "dbo.PhysPersonCheck")
public class PhysCustomer implements Serializable {

  private static final long serialVersionUID = -621667797282692035L;

  @Id
  @Column(name = "id")
  private long id;
  @Column(name = "accountNumber")
  private String accountNumber;
  @Column(name = "activeScaleCount")
  private Integer activeScaleCount;

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

  public Integer getActiveScaleCount() {
    return activeScaleCount;
  }

  public void setActiveScaleCount(Integer activeScaleCount) {
    this.activeScaleCount = activeScaleCount;
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
