package com.xiaohu.zhixuan.controller;

import com.xiaohu.zhixuan.VO.ResultVO;
import com.xiaohu.zhixuan.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    //这是测试能不能提交到github

    //
    @Autowired
    LoginServiceImpl loginService;

    @RequestMapping("/login")
    public ResultVO login(String account,String password){
        return loginService.login(account,password);
    }

    @RequestMapping("/register")
    public ResultVO register(String account,String password){
        return loginService.register(account,password);
    }
}
