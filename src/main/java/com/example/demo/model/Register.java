package com.example.demo.model;

import lombok.Data;

import java.security.cert.Extension;

@Data
public class Register {
    private String source; // 来源
    private String userId; // 用户ID
    private String name; // 用户名称
    private String identifier; // 账号名称
    private Integer identifyType; // 账号类型
    private String password; // 密码
    private String avatar; // 头像
    private String extension; // 扩展信息
    private String registerMode; // 注册模式 register 新注册 bind 绑定
    private String otpCode;
}
