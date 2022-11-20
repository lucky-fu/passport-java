package com.example.passport.dao;


import com.example.passport.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    Long insert(User user);
}
