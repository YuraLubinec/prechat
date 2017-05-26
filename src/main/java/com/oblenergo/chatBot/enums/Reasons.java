package com.oblenergo.chatBot.enums;

public enum Reasons {

  INDICATOR("indicator"), BILL("bill"), CONSULTATION("consultation"), NO_ENERGY_REPORT_JUR(
      "report_jur"), NO_ENERGY_REPORT_PHYS("report_phys");

  private String reason;

  private Reasons(String reason) {
    this.reason = reason;
  }

  public String getReason() {
    return reason;
  }

}
