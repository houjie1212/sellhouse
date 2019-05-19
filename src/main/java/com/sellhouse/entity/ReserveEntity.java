package com.sellhouse.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ReserveEntity implements Serializable {

  private static final long serialVersionUID = 1737764524390541725L;

  private String id;
  private String username;
  private String mobile;
  private LocalDateTime createTime;

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

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }
}
