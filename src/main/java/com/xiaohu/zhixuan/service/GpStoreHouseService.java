package com.xiaohu.zhixuan.service;

import com.xiaohu.zhixuan.VO.ResultVO;

public interface GpStoreHouseService {

    ResultVO findAllByGpId(long gpId);

    ResultVO findByGpIdAndMineId(long gpId,long mineId);

    ResultVO findByGpIdAndMineType(long gpId,int mineType);
}
