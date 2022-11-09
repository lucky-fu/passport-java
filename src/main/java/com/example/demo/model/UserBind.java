package com.example.demo.model;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class UserBind implements java.io.Serializable{
    private  Long id;
    private Long userId;
    private Integer identityType;
    private String identifier;
    private Integer status;
    private Map<String, Object> extension;
    private Date createTime;
    private Date modifyTime;
}
