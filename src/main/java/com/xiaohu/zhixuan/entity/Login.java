package com.xiaohu.zhixuan.entity;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {

  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Id
  private Long loginId;

  private String account;
  private String password;
  private String token;
  private Long createTime;
  private Long updateTime;

  public Long getLoginId() {
    return loginId;
  }

  public void setLoginId(Long loginId) {
    this.loginId = loginId;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }


  public Long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

}
