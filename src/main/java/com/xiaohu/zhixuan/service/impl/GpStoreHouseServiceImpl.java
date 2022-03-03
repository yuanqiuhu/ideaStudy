package com.xiaohu.zhixuan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaohu.zhixuan.VO.GpStoreHouseVO;
import com.xiaohu.zhixuan.VO.ResultVO;
import com.xiaohu.zhixuan.dao.GpDao;
import com.xiaohu.zhixuan.dao.GpStoreHouseDao;
import com.xiaohu.zhixuan.dao.MinePriceDao;
import com.xiaohu.zhixuan.dao.MineTypeDao;
import com.xiaohu.zhixuan.entity.Gp;
import com.xiaohu.zhixuan.entity.GpStoreHouse;
import com.xiaohu.zhixuan.entity.MinePrice;
import com.xiaohu.zhixuan.entity.MineType;
import com.xiaohu.zhixuan.service.GpStoreHouseService;
import com.xiaohu.zhixuan.utils.Code;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GpStoreHouseServiceImpl implements GpStoreHouseService {
    @Autowired
    GpStoreHouseDao gpStoreHouseDao;
    @Autowired
    GpDao gpDao;
    @Autowired
    MinePriceDao minePriceDao;
    @Autowired
    MineTypeDao mineTypeDao;

    @Override
    public ResultVO findAllByGpId(long gpId) {
        ResultVO resultVO = new ResultVO();
        if (gpId <= 0){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }

        List<GpStoreHouse> gpStoreHouses = gpStoreHouseDao.findAllByGpId(gpId);

        if (gpStoreHouses.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setError(Code.getError(Code.CODE_IS_NULL));
            return resultVO;
        }

        GpStoreHouseVO gpStoreHouseVO;
        List<GpStoreHouseVO> gpStoreHouseVOS = new ArrayList<>();
        MinePrice minePrice;
        for (GpStoreHouse gpStoreHouse : gpStoreHouses) {
            minePrice = minePriceDao.findByMineId(gpStoreHouse.getMineId());
            gpStoreHouseVO = new GpStoreHouseVO();
            gpStoreHouseVO.setGpId(gpStoreHouse.getGpId());
            gpStoreHouseVO.setMineId(minePrice.getMineId());
            gpStoreHouseVO.setMineName(minePrice.getMineName());
            gpStoreHouseVO.setMineTotal(gpStoreHouse.getMineTotal());
            gpStoreHouseVO.setMinePrice(minePrice.getMinePrice());
            gpStoreHouseVOS.add(gpStoreHouseVO);
        }

        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(gpStoreHouseVOS));
        return resultVO;
    }

    @Override
    public ResultVO findByGpIdAndMineId(long gpId, long mineId) {
        ResultVO resultVO = new ResultVO();
        if (gpId <= 0 || mineId <= 0){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }

        GpStoreHouse gpStoreHouse = gpStoreHouseDao.findByGpIdAndMineId(gpId,mineId);

        if (gpStoreHouse == null){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setError(Code.getError(Code.CODE_IS_NULL));
            return resultVO;
        }

        GpStoreHouseVO gpStoreHouseVO = new GpStoreHouseVO();
        MinePrice minePrice = minePriceDao.findByMineId(mineId);

        gpStoreHouseVO.setMineName(minePrice.getMineName());
        gpStoreHouseVO.setMineId(minePrice.getMineId());
        gpStoreHouseVO.setGpId(gpStoreHouse.getGpId());
        gpStoreHouseVO.setMineTotal(gpStoreHouse.getMineTotal());

        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(gpStoreHouseVO));
        return resultVO;
    }

    @Override
    public ResultVO findByGpIdAndMineType(long gpId, int mineType) {
        ResultVO resultVO = new ResultVO();
        if (gpId <= 0 || mineType <= 0){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }
        List<MinePrice> minePrices = minePriceDao.findAllByMineType(mineType);

        List<GpStoreHouseVO> gpStoreHouseVOS = new ArrayList<>();
        GpStoreHouseVO gpStoreHouseVO;
        GpStoreHouse gpStoreHouse;
        for (MinePrice minePrice : minePrices){
            gpStoreHouseVO = new GpStoreHouseVO();
            gpStoreHouse = gpStoreHouseDao.findByGpIdAndMineId(gpId,minePrice.getMineId());
            if (gpStoreHouse == null){
                continue;
            }
            gpStoreHouseVO.setMinePrice(minePrice.getMinePrice());
            gpStoreHouseVO.setMineId(minePrice.getMineId());
            gpStoreHouseVO.setMineTotal(gpStoreHouse.getMineTotal());
            gpStoreHouseVO.setGpId(gpStoreHouse.getGpId());
            gpStoreHouseVO.setMineName(minePrice.getMineName());
            gpStoreHouseVOS.add(gpStoreHouseVO);
        }

        if (gpStoreHouseVOS.size() <= 0){
            resultVO.setCode(Code.DATA_IS_NULL);
            resultVO.setError(Code.getError(Code.DATA_IS_NULL));
            return resultVO;
        }

        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(gpStoreHouseVOS));
        return resultVO;
    }
}
