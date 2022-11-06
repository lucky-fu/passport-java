package com.example.demo.mapper;

import com.example.demo.model.UserBind;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserBindMapper {
    void insert(UserBind userBind);
}
