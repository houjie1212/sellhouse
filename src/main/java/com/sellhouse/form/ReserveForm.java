package com.sellhouse.form;

import java.io.Serializable;

public class ReserveForm implements Serializable {

  private static final long serialVersionUID = -8841889320463141502L;

  private String id;
  private String username;
  private String mobile;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }
}
