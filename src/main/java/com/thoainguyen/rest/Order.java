package com.thoainguyen.rest;

import java.io.Serializable;

public class Order implements Serializable {
  private String field;

  public Order(String field) {
    this.field = field;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }
}
