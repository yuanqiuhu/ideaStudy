package com.xiaohu.zhixuan.dao;

import com.xiaohu.zhixuan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByUserId(String userId);

    User findByLoginId(long loginId);
}
