package com.xiaohu.zhixuan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaohu.zhixuan.VO.ResultVO;
import com.xiaohu.zhixuan.VO.UserGiveToGpVO;
import com.xiaohu.zhixuan.dao.MinePriceDao;
import com.xiaohu.zhixuan.dao.UserDao;
import com.xiaohu.zhixuan.dao.UserGiveToGpDao;
import com.xiaohu.zhixuan.entity.MinePrice;
import com.xiaohu.zhixuan.entity.User;
import com.xiaohu.zhixuan.entity.UserGiveToGp;
import com.xiaohu.zhixuan.service.UserGiveToGpService;
import com.xiaohu.zhixuan.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserGiveToGpServiceImpl implements UserGiveToGpService {

    @Autowired
    UserGiveToGpDao userGiveToGpDao;
    @Autowired
    MinePriceDao minePriceDao;
    @Autowired
    UserDao userDao;

    @Override
    public ResultVO findAllByGpId(long gpId) {
        ResultVO resultVO = new ResultVO();
        if (gpId <= 0){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGp> userGiveToGps = userGiveToGpDao.findAllByGpId(gpId);

        if (userGiveToGps.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setError(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGpVO> userGiveToGpVOS = new ArrayList<>();
        UserGiveToGpVO userGiveToGpVO;
        for (UserGiveToGp userGiveToGp : userGiveToGps){
            userGiveToGpVO = new UserGiveToGpVO();
            userGiveToGpVO.setOrderId(userGiveToGp.getOrderId());
            userGiveToGpVO.setGpId(userGiveToGp.getGpId());
            userGiveToGpVO.setUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setOrderTotal(userGiveToGp.getOrderTotal());
            userGiveToGpVO.setOrderType(userGiveToGp.getOrderType());
            MinePrice minePrice = minePriceDao.findByMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setMineName(minePrice.getMineName());
            userGiveToGpVO.setOrderPrice((float)(userGiveToGp.getOrderTotal() * minePrice.getMinePrice()));
            User user = userDao.findByUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setUserName(user.getUserName());
            userGiveToGpVOS.add(userGiveToGpVO);
        }

        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(userGiveToGpVOS));
        return resultVO;
    }

    @Override
    public ResultVO findAllByMineId(long mineId) {
        ResultVO resultVO = new ResultVO();
        if (mineId <= 0){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGp> userGiveToGps = userGiveToGpDao.findAllByMineId(mineId);

        if (userGiveToGps.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setError(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGpVO> userGiveToGpVOS = new ArrayList<>();
        UserGiveToGpVO userGiveToGpVO;
        for (UserGiveToGp userGiveToGp : userGiveToGps){
            userGiveToGpVO = new UserGiveToGpVO();
            userGiveToGpVO.setOrderId(userGiveToGp.getOrderId());
            userGiveToGpVO.setGpId(userGiveToGp.getGpId());
            userGiveToGpVO.setUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setOrderTotal(userGiveToGp.getOrderTotal());
            userGiveToGpVO.setOrderType(userGiveToGp.getOrderType());
            MinePrice minePrice = minePriceDao.findByMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setMineName(minePrice.getMineName());
            userGiveToGpVO.setOrderPrice((float)(userGiveToGp.getOrderTotal() * minePrice.getMinePrice()));
            User user = userDao.findByUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setUserName(user.getUserName());
            userGiveToGpVOS.add(userGiveToGpVO);
        }

        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(userGiveToGpVOS));
        return resultVO;
    }

    @Override
    public ResultVO findAllByUserId(long userId) {
        ResultVO resultVO = new ResultVO();
        if (userId <= 0){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGp> userGiveToGps = userGiveToGpDao.findAllByUserId(userId);

        if (userGiveToGps.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setError(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGpVO> userGiveToGpVOS = new ArrayList<>();
        UserGiveToGpVO userGiveToGpVO;
        for (UserGiveToGp userGiveToGp : userGiveToGps){
            userGiveToGpVO = new UserGiveToGpVO();
            userGiveToGpVO.setOrderId(userGiveToGp.getOrderId());
            userGiveToGpVO.setGpId(userGiveToGp.getGpId());
            userGiveToGpVO.setUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setOrderTotal(userGiveToGp.getOrderTotal());
            userGiveToGpVO.setOrderType(userGiveToGp.getOrderType());
            MinePrice minePrice = minePriceDao.findByMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setMineName(minePrice.getMineName());
            userGiveToGpVO.setOrderPrice((float)(userGiveToGp.getOrderTotal() * minePrice.getMinePrice()));
            User user = userDao.findByUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setUserName(user.getUserName());
            userGiveToGpVOS.add(userGiveToGpVO);
        }

        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(userGiveToGpVOS));
        return resultVO;
    }

    @Override
    public ResultVO findAllByUserIdAndGpId(long useId, long gpId) {
        ResultVO resultVO = new ResultVO();
        if (gpId <= 0 || useId <= 0){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGp> userGiveToGps = userGiveToGpDao.findAllByUserIdAndGpId(useId,gpId);

        if (userGiveToGps.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setError(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGpVO> userGiveToGpVOS = new ArrayList<>();
        UserGiveToGpVO userGiveToGpVO;
        for (UserGiveToGp userGiveToGp : userGiveToGps){
            userGiveToGpVO = new UserGiveToGpVO();
            userGiveToGpVO.setOrderId(userGiveToGp.getOrderId());
            userGiveToGpVO.setGpId(userGiveToGp.getGpId());
            userGiveToGpVO.setUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setOrderTotal(userGiveToGp.getOrderTotal());
            userGiveToGpVO.setOrderType(userGiveToGp.getOrderType());
            MinePrice minePrice = minePriceDao.findByMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setMineName(minePrice.getMineName());
            userGiveToGpVO.setOrderPrice((float)(userGiveToGp.getOrderTotal() * minePrice.getMinePrice()));
            User user = userDao.findByUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setUserName(user.getUserName());
            userGiveToGpVOS.add(userGiveToGpVO);
        }

        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(userGiveToGpVOS));
        return resultVO;
    }

    @Override
    public ResultVO findAllByGpIdAndMineId(long gpId, long mineId) {
        ResultVO resultVO = new ResultVO();
        if (gpId <= 0 || mineId <= 0){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGp> userGiveToGps = userGiveToGpDao.findAllByGpIdAndMineId(gpId,mineId);

        if (userGiveToGps.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setError(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGpVO> userGiveToGpVOS = new ArrayList<>();
        UserGiveToGpVO userGiveToGpVO;
        for (UserGiveToGp userGiveToGp : userGiveToGps){
            userGiveToGpVO = new UserGiveToGpVO();
            userGiveToGpVO.setOrderId(userGiveToGp.getOrderId());
            userGiveToGpVO.setGpId(userGiveToGp.getGpId());
            userGiveToGpVO.setUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setOrderTotal(userGiveToGp.getOrderTotal());
            userGiveToGpVO.setOrderType(userGiveToGp.getOrderType());
            MinePrice minePrice = minePriceDao.findByMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setMineName(minePrice.getMineName());
            userGiveToGpVO.setOrderPrice((float)(userGiveToGp.getOrderTotal() * minePrice.getMinePrice()));
            User user = userDao.findByUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setUserName(user.getUserName());

            userGiveToGpVOS.add(userGiveToGpVO);
        }

        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(userGiveToGpVOS));
        return resultVO;
    }

    @Override
    public ResultVO findAllByUserIdAndMineId(long userId, long mineId) {
        ResultVO resultVO = new ResultVO();
        if (userId <= 0 || mineId <= 0){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGp> userGiveToGps = userGiveToGpDao.findAllByUserIdAndMineId(userId,mineId);

        if (userGiveToGps.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setError(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }

        List<UserGiveToGpVO> userGiveToGpVOS = new ArrayList<>();
        UserGiveToGpVO userGiveToGpVO;
        for (UserGiveToGp userGiveToGp : userGiveToGps){
            userGiveToGpVO = new UserGiveToGpVO();
            userGiveToGpVO.setOrderId(userGiveToGp.getOrderId());
            userGiveToGpVO.setGpId(userGiveToGp.getGpId());
            userGiveToGpVO.setUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setOrderTotal(userGiveToGp.getOrderTotal());
            userGiveToGpVO.setOrderType(userGiveToGp.getOrderType());
            MinePrice minePrice = minePriceDao.findByMineId(userGiveToGp.getMineId());
            userGiveToGpVO.setMineName(minePrice.getMineName());
            userGiveToGpVO.setOrderPrice((float)(userGiveToGp.getOrderTotal() * minePrice.getMinePrice()));
            User user = userDao.findByUserId(userGiveToGp.getUserId());
            userGiveToGpVO.setUserName(user.getUserName());
            userGiveToGpVOS.add(userGiveToGpVO);
        }

        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(userGiveToGpVOS));
        return resultVO;
    }

    @Override
    public ResultVO insertNewGiveOrder(UserGiveToGpVO userGiveToGpVO) {
        ResultVO resultVO = new ResultVO();
        if (userGiveToGpVO == null){
            resultVO.setCode(Code.DATA_INSERT_FAIL);
            resultVO.setError(Code.getError(Code.DATA_INSERT_FAIL));
            return resultVO;
        }

        UserGiveToGp userGiveToGp = new UserGiveToGp();
        userGiveToGp.setGpId(userGiveToGpVO.getGpId());
        userGiveToGp.setUserId(userGiveToGpVO.getUserId());
        userGiveToGp.setMineId(userGiveToGpVO.getMineId());
        userGiveToGp.setOrderTotal(userGiveToGpVO.getOrderTotal());
        userGiveToGp.setOrderType(userGiveToGpVO.getOrderType());
        MinePrice minePrice = minePriceDao.findByMineId(userGiveToGpVO.getMineId());
        userGiveToGp.setOrderPrice(minePrice.getMinePrice() * userGiveToGpVO.getOrderTotal());
        UserGiveToGp backUserGiveToGp = userGiveToGpDao.save(userGiveToGp);
        if (backUserGiveToGp == null){
            resultVO.setCode(Code.DATA_INSERT_FAIL);
            resultVO.setError(Code.getError(Code.DATA_INSERT_FAIL));
            return resultVO;
        }

        resultVO.setCode(Code.SUCCESS);
        return resultVO;
    }

    @Override
    public ResultVO insertNewGiveOrder(List<UserGiveToGpVO> userGiveToGpVOS) {
        ResultVO resultVO = new ResultVO();
        if (userGiveToGpVOS.size() <= 0){
            resultVO.setCode(Code.DATA_INSERT_FAIL);
            resultVO.setError(Code.getError(Code.DATA_INSERT_FAIL));
            return resultVO;
        }
        List<UserGiveToGp> errorUserGiveToGps = new ArrayList<>();
        UserGiveToGp userGiveToGp;
        for (UserGiveToGpVO userGiveToGpVO : userGiveToGpVOS){
            userGiveToGp = new UserGiveToGp();
            userGiveToGp.setGpId(userGiveToGpVO.getGpId());
            userGiveToGp.setUserId(userGiveToGpVO.getUserId());
            userGiveToGp.setMineId(userGiveToGpVO.getMineId());
            userGiveToGp.setOrderTotal(userGiveToGpVO.getOrderTotal());
            userGiveToGp.setOrderType(userGiveToGpVO.getOrderType());
            MinePrice minePrice = minePriceDao.findByMineId(userGiveToGpVO.getMineId());
            userGiveToGp.setOrderPrice(minePrice.getMinePrice() * userGiveToGpVO.getOrderTotal());
            UserGiveToGp backUserGiveToGp = userGiveToGpDao.save(userGiveToGp);
            if (backUserGiveToGp == null){
                errorUserGiveToGps.add(userGiveToGp);
            }
        }

        if (errorUserGiveToGps.size() <= 0){
            resultVO.setCode(Code.DATA_INSERT_FAIL);
            resultVO.setError(Code.getError(Code.DATA_INSERT_FAIL));
            resultVO.setData(JSONObject.toJSONString(errorUserGiveToGps));
            return resultVO;
        }

        resultVO.setCode(Code.SUCCESS);
        return resultVO;
    }
}
