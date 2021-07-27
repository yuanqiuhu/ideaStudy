package com.xiaohu.zhixuan.entity;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private long userId;
  private String userName;
  private long userSex;
  private long userBirth;
  private String userNick;
  private long createTime;
  private long updateTime;
  private long loginId;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public long getUserSex() {
    return userSex;
  }

  public void setUserSex(long userSex) {
    this.userSex = userSex;
  }


  public long getUserBirth() {
    return userBirth;
  }

  public void setUserBirth(long userBirth) {
    this.userBirth = userBirth;
  }


  public String getUserNick() {
    return userNick;
  }

  public void setUserNick(String userNick) {
    this.userNick = userNick;
  }


  public long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(long createTime) {
    this.createTime = createTime;
  }


  public long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(long updateTime) {
    this.updateTime = updateTime;
  }


  public long getLoginId() {
    return loginId;
  }

  public void setLoginId(long loginId) {
    this.loginId = loginId;
  }

}
