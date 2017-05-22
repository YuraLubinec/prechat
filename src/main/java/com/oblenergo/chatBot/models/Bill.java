package com.oblenergo.chatBot.models;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Bill implements Serializable {

  private static final long serialVersionUID = -5355264735966312855L;
  private String value;
  private String forDate;

  public Bill() {
    super();
  }

  public Bill(String value, String forDate) {
    super();
    this.value = value;
    this.forDate = forDate;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getForDate() {
    return forDate;
  }

  public void setForDate(String forDate) {
    this.forDate = forDate;
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
