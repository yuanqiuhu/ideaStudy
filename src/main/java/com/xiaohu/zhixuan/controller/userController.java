package com.xiaohu.zhixuan.controller;

import com.xiaohu.zhixuan.VO.ResultVO;
import com.xiaohu.zhixuan.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    LoginServiceImpl loginService;
    @Autowired
    MinePriceServiceImpl minePriceService;
    @Autowired
    GroupServiceImpl groupService;
    @Autowired
    GpStoreHouseServiceImpl gpStoreHouseService;
    @Autowired
    UserGiveToGpServiceImpl userGiveToGpService;

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
        return minePriceService.findAllByMineNameIsNotNull();
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

    @RequestMapping("/getGroupById")
    public ResultVO getGroupById(long groupId){
        return groupService.findByGroupId(groupId);
    }

    @RequestMapping("/getGpHouseByGpId")
    public ResultVO getGpHouseByGpId(long gpId){
        return gpStoreHouseService.findAllByGpId(gpId);
    }

    @RequestMapping("/getGpHouseByGpIdAndMineId")
    public ResultVO getGpHouseByGpIdAndMineId(long gpId,long mineId){
        return gpStoreHouseService.findByGpIdAndMineId(gpId,mineId);
    }

    @RequestMapping("/getMineType")
    public ResultVO getMineType(){
        return minePriceService.getMineType();
    }

    @RequestMapping("/getGpHouseByGpIdAndMineType")
    public ResultVO getGpHouseByGpIdAndMineType(long gpId,int mineType){
        return gpStoreHouseService.findByGpIdAndMineType(gpId,mineType);
    }

    @RequestMapping("/getAllGiveOrderByGpId")
    public ResultVO getAllGiveOrderByGpId(long gpId){
        return userGiveToGpService.findAllByGpId(gpId);
    }

    @RequestMapping("/getAllGiveOrderByUserId")
    public ResultVO getAllGiveOrderByUserId(long userId){
        return userGiveToGpService.findAllByUserId(userId);
    }

    @RequestMapping("/getAllGiveOrderByMineId")
    public ResultVO getAllGiveOrderByMineId(long mineId){
        return userGiveToGpService.findAllByMineId(mineId);
    }

    @RequestMapping("/findAllByUserIdAndGpId")
    public ResultVO findAllByUserIdAndGpId(long userId,long gpId){
        return userGiveToGpService.findAllByUserIdAndGpId(userId,gpId);
    }

    @RequestMapping("/findAllByGpIdAndMineId")
    public ResultVO findAllByGpIdAndMineId(long gpId,long mineId){
        return userGiveToGpService.findAllByGpIdAndMineId(gpId,mineId);
    }

    @RequestMapping("/findAllByUserIdAndMineId")
    public ResultVO findAllByUserIdAndMineId(long userId,long mineId){
        return userGiveToGpService.findAllByUserIdAndMineId(userId,mineId);
    }
}
