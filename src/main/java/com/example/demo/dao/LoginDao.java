package com.example.demo.dao;

import com.example.demo.entity.Login;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface LoginDao extends JpaRepository<Login,Integer> {

    Login findByAccount(String account);

    @Transactional
    @Modifying
    @Query("update Login t set t.password = :password where t.account = :account")
    int updateLoginPassword(@Param("password") String password,@Param("account") String account);
}
