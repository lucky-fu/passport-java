package com.example.passport.service.impl;

import com.example.passport.dao.UserBindDao;
import com.example.passport.dao.UserDao;
import com.example.passport.model.UserBind;
import com.example.passport.service.UserService;
import com.example.passport.model.User;
import com.example.passport.entity.RegisterDTO;
import com.example.passport.entity.RegisterResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static final String REGISTER_MODE_REGISTER = "register";
    private static final String REGISTER_MODE_BIND = "bind";
    private static final String REGISTER_MODE_REGISTER_AND_BIND = "register_and_login";
    private User user;
    private UserBind userBind;
    @Autowired
    private UserBindDao userBindDao;
    @Autowired
    private UserDao userDao;


    public RegisterResultDTO Register(RegisterDTO param) throws Exception {
        switch (param.getRegisterMode()){
            case REGISTER_MODE_REGISTER:
                user = register(param);
                break;
            case REGISTER_MODE_BIND:
                user = bind(convertRegisterToUser(param));
                break;
            case REGISTER_MODE_REGISTER_AND_BIND:
                user = registerAndBind(convertRegisterToUser(param));
                break;
            default:
                throw new Exception("非法的注册方式");
        }

        return RegisterResultDTO.builder().userId(user.getId()).build();
    }

    public User register(RegisterDTO param) throws Exception {
        try {
            userBind = userBindDao.getInfoByIdentifier(param.getIdentifyType(), param.getIdentifier());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        if (userBind.getUserId() > 0) {
            throw new Exception("账号已经被其他用户注册");
        }

        user = insertUser(param);

        return user;
    }

    @Transactional
    public User insertUser(RegisterDTO param) {

        Long userId = userDao.insert(user);
        userBind.setUserId(userId);
        userBindDao.insert(userBind);

        return user;
    }

    public User bind(User user) throws Exception {
        return user;
    }

    public User registerAndBind(User user) throws Exception{
        return user;
    }

    public User convertRegisterToUser(RegisterDTO param) {
        user.setName(param.getName());
        user.setAvatar(param.getAvatar());
        user.setBindAccountList(param.getBindAccountListString());
        user.setExtension(param.getExtension());
        return user;
    }

    public UserBind convertRegisterToUserBind(RegisterDTO param) {
        userBind.setIdentifier(param.getIdentifier());
        userBind.setIdentityType(param.getIdentifyType());
        userBind.setUserId(param.getUserId());
        return userBind;
    }
}
