package com.example.demo;

import com.example.demo.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedisServiceTest {
    @Resource
    private RedisService redisService;

    @Test
    public void set() throws Exception {
        redisService.set("test", "value", 10);
    }

    @Test
    public void get() throws Exception {
        String result = redisService.get("test");
        System.out.printf("获取到的redis值为：%s", result);
    }
}
