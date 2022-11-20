package com.example.passport.controller;

import com.example.passport.entity.RegisterDTO;
import com.example.passport.model.RestResp;
import com.example.passport.service.UserService;
import com.example.passport.entity.RegisterResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public RestResp hello() {
        return RestResp.ok();
    }

    @RequestMapping("/api")
    public RestResp api() {
        restTemplate.getForEntity("", String.class);
        return RestResp.ok();
    }

    @PostMapping("/register")
    public RestResp register(@Validated @RequestBody RegisterDTO registerParam) throws Exception {
        RegisterResultDTO result = null;

        try {
            result = userService.Register(registerParam);
        }catch (Exception e){
            return RestResp.error(-1, e.getMessage());
        }

        return  RestResp.success(result);
    }
}
