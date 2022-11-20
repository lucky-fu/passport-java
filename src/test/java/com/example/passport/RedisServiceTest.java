package com.example.passport;

import com.example.passport.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class RedisServiceTest {
    @Resource
    private RedisService redisService;

    @Test
    public void set() throws Exception {
        redisService.set("test", "value", 100);
    }

    @Test
    public void get() throws Exception {
        String result = redisService.get("test");
        System.out.printf("获取到的redis值为：%s", result);
        log.debug("获取到的redis值为");
    }

    @Test
    public void log() throws Exception {
        log.error("获取到的redis值为");
    }
}
