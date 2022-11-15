package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.RestResp;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    }

    @PostMapping("/register")
    public RestResp register(@RequestBody User user) {
        Integer num = userService.Register(user);
        return  RestResp.success(num);
    }
}
