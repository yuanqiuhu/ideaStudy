package com.xiaohu.zhixuan.VO;

public class LoginVO {
    //用户id
    private Long loginId;
    //用户账号
    private String account;

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
}
