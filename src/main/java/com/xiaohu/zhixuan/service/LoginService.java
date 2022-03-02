package com.xiaohu.zhixuan.service;

import com.xiaohu.zhixuan.VO.ResultVO;

public interface LoginService {

    ResultVO login(String account,String password);

    ResultVO loginByToken(String account, String token);

    ResultVO register(String account, String password, String userName, String userSex, String userAge, String userNickName);

    ResultVO changePassword(String account,String password,String newPassword);

    ResultVO takeBackPassword(String account,String password);

    ResultVO getAndSureCode(int status,String code,String account);

}
