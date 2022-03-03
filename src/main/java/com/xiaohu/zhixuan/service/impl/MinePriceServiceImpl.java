package com.xiaohu.zhixuan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaohu.zhixuan.VO.MinePriceVO;
import com.xiaohu.zhixuan.VO.MineTypeVO;
import com.xiaohu.zhixuan.VO.ResultVO;
import com.xiaohu.zhixuan.dao.MinePriceDao;
import com.xiaohu.zhixuan.dao.MineTypeDao;
import com.xiaohu.zhixuan.entity.MinePrice;
import com.xiaohu.zhixuan.entity.MineType;
import com.xiaohu.zhixuan.service.MinePriceService;
import com.xiaohu.zhixuan.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MinePriceServiceImpl implements MinePriceService {

    @Autowired
    MinePriceDao minePriceDao;
    @Autowired
    MineTypeDao mineTypeDao;

    @Override
    public ResultVO findAllMine() {
        ResultVO resultVO = new ResultVO();
        List<MinePrice> minePrices = minePriceDao.findAll();
        if (minePrices.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setMessage(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }
        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(minePrices.toString());
        return resultVO;
    }

    @Override
    public ResultVO findAllByMineNameIsNotNull() {
        ResultVO resultVO = new ResultVO();
        List<MinePrice> minePrices = minePriceDao.findAllByMineNameIsNotNull();
        if (minePrices.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setMessage(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }

        MinePriceVO minePriceVO;
        List<MinePriceVO> minePriceVOS = new ArrayList<>();
        for (MinePrice minePrice : minePrices){
            minePriceVO = new MinePriceVO();
            minePriceVO.setMineId(minePrice.getMineId());
            minePriceVO.setMinePrice(minePrice.getMinePrice());
            minePriceVO.setMineName(minePrice.getMineName());
            minePriceVO.setMineType(minePrice.getMineType());
            minePriceVOS.add(minePriceVO);
        }
        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(minePriceVOS));
        return resultVO;
    }

    @Override
    public ResultVO findByMineType(int type) {
        ResultVO resultVO = new ResultVO();
        List<MinePrice> minePrices = minePriceDao.findAllByMineType(type);
        if (minePrices.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setMessage(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }
        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(minePrices));
        return resultVO;
    }

    @Override
    public ResultVO findByMineId(long id) {
        ResultVO resultVO = new ResultVO();
        MinePrice minePrices = minePriceDao.findByMineId(id);
        if (minePrices == null){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setMessage(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }
        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(minePrices.toString());
        return resultVO;
    }

    @Override
    public ResultVO findByMineName(String name) {
        ResultVO resultVO = new ResultVO();
        MinePrice minePrices = minePriceDao.findByMineName(name);
        if (minePrices == null){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setMessage(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }
        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(minePrices.toString());
        return resultVO;
    }

    @Override
    public ResultVO updateMinePrice(float price, long mineId) {
        ResultVO resultVO = new ResultVO();
        MinePrice minePrices = minePriceDao.findByMineId(mineId);
        if (minePrices == null){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setMessage(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }

        int num = minePriceDao.updateMinePrice(price,mineId);
        if (num <= 0){
            resultVO.setCode(Code.DATA_CHANGE_FAIL);
            resultVO.setError(Code.getError(Code.DATA_CHANGE_FAIL));
            return resultVO;
        }
        resultVO.setCode(Code.SUCCESS);
        return resultVO;
    }

    @Override
    public ResultVO insertNewMine(String name, float price, int type) {
        ResultVO resultVO = new ResultVO();
        if (name == null || price < 0 || type < 0){
            //账号不能为空
            resultVO.setCode(Code.DATA_INSERT_FAIL);
            resultVO.setError(Code.getError(Code.DATA_INSERT_FAIL));
            return resultVO;
        }
        MinePrice minePrice = new MinePrice();
        minePrice.setMineName(name);
        minePrice.setMinePrice(price);
        minePrice.setMineType(type);

        MinePrice minePrice1 = minePriceDao.save(minePrice);

        if (minePrice1 == null){
            //注册失败
            resultVO.setCode(Code.DATA_CHANGE_FAIL);
            resultVO.setError(Code.getError(Code.DATA_CHANGE_FAIL));
            return resultVO;
        }

        //添加成功
        resultVO.setCode(Code.SUCCESS);
        return resultVO;
    }

    @Override
    public ResultVO getMineType() {
        ResultVO resultVO = new ResultVO();

        List<MineType> mineTypes = mineTypeDao.findAllByMineTypeNameIsNotNull();

        if (mineTypes.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setError(Code.getError(Code.CODE_IS_NULL));
            return resultVO;
        }

        List<MineTypeVO> mineTypeVOS = new ArrayList<>();
        MineTypeVO mineTypeVO;
        for (MineType mineType : mineTypes){
            mineTypeVO = new MineTypeVO();
            mineTypeVO.setMineTypeId(mineType.getMineTypeId());
            mineTypeVO.setMineTypeName(mineType.getMineTypeName());
            mineTypeVOS.add(mineTypeVO);
        }
        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(mineTypeVOS));
        return resultVO;
    }
}
