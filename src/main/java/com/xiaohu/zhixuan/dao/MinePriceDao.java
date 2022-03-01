package com.xiaohu.zhixuan.dao;

import com.xiaohu.zhixuan.entity.Login;
import com.xiaohu.zhixuan.entity.MinePrice;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface MinePriceDao extends JpaRepository<MinePrice,Integer> {

    List<MinePrice> findAll();

    List<MinePrice> findAllByMineType(int type);

    MinePrice findByMineName(String name);

    MinePrice findByMineId(long id);

    @Transactional
    @Modifying
    @Query("update MinePrice t set t.minePrice = :minePrice where t.mineId = :mineId")
    int updateMinePrice(@Param("minePrice") float minePrice, @Param("mineId") long mineId);
}
