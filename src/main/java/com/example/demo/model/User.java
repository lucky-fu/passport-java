package com.example.demo.model;

import lombok.Data;
import java.util.Date;
import java.util.Map;

@Data
public class User {
    private Long id;
    private String name;
    private String avatar;
    private String introduce;
    private Integer status;
    private Map<String, Object> extension;
    private Date createTime;
    private Date modifyTime;
}
