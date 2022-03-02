package com.xiaohu.zhixuan.controller;

import com.xiaohu.zhixuan.VO.ResultVO;
import com.xiaohu.zhixuan.service.MinePriceService;
import com.xiaohu.zhixuan.service.impl.LoginServiceImpl;
import com.xiaohu.zhixuan.service.impl.MinePriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    LoginServiceImpl loginService;
    @Autowired
    MinePriceServiceImpl minePriceService;

    @RequestMapping("/login")
    public ResultVO login(String account,String password){
        return loginService.login(account,password);
    }

    @RequestMapping("/loginByToken")
    public ResultVO loginByToken(String account,String token){
        return loginService.loginByToken(account,token);
    }

    @RequestMapping("/register")
    public ResultVO register(String account, String password, String userName, String userType, String userLevel, String userGroupId){
        return loginService.register(account,password,userName,userType,userLevel,userGroupId);
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

    @RequestMapping("/getAllMine")
    public ResultVO getAllMine(){
        return minePriceService.findAllMine();
    }

    @RequestMapping("/getMineByType")
    public ResultVO getMineByType(int type){
        return minePriceService.findByMineType(type);
    }

    @RequestMapping("/getMineByID")
    public ResultVO getMineByType(long id){
        return minePriceService.findByMineId(id);
    }

    @RequestMapping("/getMineByName")
    public ResultVO getMineByType(String name){
        return minePriceService.findByMineName(name);
    }

    @RequestMapping("/updateMinePrice")
    public ResultVO updatePassword(float price,long mineId){
        return minePriceService.updateMinePrice(price,mineId);
    }

}
