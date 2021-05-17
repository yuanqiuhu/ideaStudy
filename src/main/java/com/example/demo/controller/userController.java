package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.service.impl.LoginServiceImpl;
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
    public ResultVO register(String account,String password){
        return loginService.register(account,password);
    }
}
