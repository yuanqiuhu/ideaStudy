package com.xiaohu.zhixuan.dao;

import com.xiaohu.zhixuan.entity.UserGiveToGp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserGiveToGpDao extends JpaRepository<UserGiveToGp,Integer> {

    List<UserGiveToGp> findAllByGpId(long gpId);

    List<UserGiveToGp> findAllByMineId(long mineId);

    List<UserGiveToGp> findAllByUserId(long userId);

    List<UserGiveToGp> findAllByUserIdAndGpId(long userId,long gpId);

    List<UserGiveToGp> findAllByGpIdAndMineId(long gpID,long mineId);

    List<UserGiveToGp> findAllByUserIdAndMineId(long userId,long mineId);
}
