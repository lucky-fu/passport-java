package com.example.passport.model;

import lombok.Data;
import java.util.Date;
import java.util.Map;

@Data
public class User implements java.io.Serializable{
    private Long id;
    private String name ="";
    private String avatar = "";
    private String introduce = "";
    private Integer status = 0;
    private String BindAccountList = "[]";
    private String extension = "{}";
    private Date createTime;
    private Date modifyTime;
}
