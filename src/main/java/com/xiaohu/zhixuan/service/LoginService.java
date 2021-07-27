package com.xiaohu.zhixuan.service;

import com.xiaohu.zhixuan.VO.ResultVO;

public interface LoginService {

    ResultVO login(String account,String password);

    ResultVO register(String account,String password);

    ResultVO changePassword(String account,String password,String newPassword);

}
