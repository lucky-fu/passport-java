package com.example.passport.service;

import com.example.passport.entity.RegisterDTO;
import com.example.passport.entity.RegisterResultDTO;

public interface UserService {
    public RegisterResultDTO Register(RegisterDTO registerParam) throws Exception;
}
