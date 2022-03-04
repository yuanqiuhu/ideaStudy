package com.xiaohu.zhixuan.dao;

import com.xiaohu.zhixuan.entity.Gp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpDao extends JpaRepository<Gp,Integer> {
    Gp findByGpId(long id);
}
