package com.example.passport.dao;

import com.example.passport.model.UserBind;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserBindDao {
    void insert(UserBind userBind);
    UserBind getInfoByIdentifier(Integer identifyType, String identifier);
    UserBind getInfoByUserId(String userId);
}
