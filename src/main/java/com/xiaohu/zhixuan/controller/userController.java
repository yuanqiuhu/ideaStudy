package com.xiaohu.zhixuan.controller;

import com.xiaohu.zhixuan.VO.ResultVO;
import com.xiaohu.zhixuan.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    LoginServiceImpl loginService;

    @RequestMapping("/login")
    public ResultVO login(String account,String password){
        return loginService.login(account,password);
    }

    @RequestMapping("/register")
    public ResultVO register(String account, String password, String userName, String userSex, String userAge, String userNickName){
        return loginService.register(account,password,userName,userSex,userAge,userNickName);
    }

    @RequestMapping("/updatePassword")
    public ResultVO updatePassword(String account,String password,String newPassword){
        return loginService.changePassword(account,password,newPassword);
    }

    @RequestMapping("/takeBackPassword")
    public ResultVO takeBackPassword(String account,String password){
        return  loginService.takeBackPassword(account,password);
    }

    @RequestMapping("/getAndSureCode")
    public ResultVO getAndSureCode(String status,String account,String code){
        return  loginService.getAndSureCode(Integer.parseInt(status),account,code);
    }
}
