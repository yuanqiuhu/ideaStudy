package com.xiaohu.zhixuan.service;

import com.xiaohu.zhixuan.VO.ResultVO;

public interface MinePriceService {

    ResultVO findAllMine();

    ResultVO findByMineType(int type);

    ResultVO findByMineId(long id);

    ResultVO findByMineName(String name);

    ResultVO updateMinePrice(float price,long mineId);

    ResultVO insertNewMine(String name,float price,int type);
}
