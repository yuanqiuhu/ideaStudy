package com.xiaohu.zhixuan.service;

import com.xiaohu.zhixuan.VO.ResultVO;
import com.xiaohu.zhixuan.VO.UserGiveToGpVO;
import com.xiaohu.zhixuan.entity.UserGiveToGp;

import java.util.List;

public interface UserGiveToGpService {

    ResultVO findAllByGpId(long gpId);

    ResultVO findAllByMineId(long mineId);

    ResultVO findAllByUserId(long userId);

    ResultVO findAllByUserIdAndGpId(long useId,long gpId);

    ResultVO findAllByGpIdAndMineId(long gpId,long mineId);

    ResultVO findAllByUserIdAndMineId(long userId,long mineId);

    ResultVO insertNewGiveOrder(UserGiveToGpVO userGiveToGpVO);

    ResultVO insertNewGiveOrder(List<UserGiveToGpVO> userGiveToGpVOS);

}