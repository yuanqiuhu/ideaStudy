package com.xiaohu.zhixuan.dao;

import com.xiaohu.zhixuan.entity.Gp;
import com.xiaohu.zhixuan.entity.GpStoreHouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GpStoreHouseDao extends JpaRepository<GpStoreHouse,Integer> {

    List<GpStoreHouse> findAllByGpId(long gpId);

    GpStoreHouse findByGpIdAndMineId(long gpId,long mineId);


}
