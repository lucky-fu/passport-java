package com.example.demo.service;

import org.springframework.stereotype.Service;

public interface RedisService {
    boolean set(String key,String val,long timeout) throws Exception;
    String get(String key) throws Exception;

}
