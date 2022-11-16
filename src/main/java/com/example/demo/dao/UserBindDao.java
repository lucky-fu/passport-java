package com.example.demo.dao;

import com.example.demo.model.UserBind;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserBindDao {
    void insert(UserBind userBind);
}
