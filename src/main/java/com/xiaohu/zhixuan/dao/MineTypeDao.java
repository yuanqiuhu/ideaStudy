package com.xiaohu.zhixuan.dao;

import com.xiaohu.zhixuan.entity.MineType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MineTypeDao extends JpaRepository<MineType,Integer> {

    List<MineType> findAllByMineTypeNameIsNotNull();
}
