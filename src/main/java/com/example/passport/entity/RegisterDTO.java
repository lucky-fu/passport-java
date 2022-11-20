package com.example.passport.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.sf.oval.constraint.NotNull;
import org.intellij.lang.annotations.Identifier;

import java.util.ArrayList;
import java.util.List;

@Data
public class RegisterDTO {
    @NotNull(message = "source为空")
    private String source; // 来源
    @NotNull(message = "identifier为空")
    private String identifier; // 账号名称
    @NotNull(message = "identifierType为空")
    @JsonProperty("identify_type")
    private Integer identifyType; // 账号类型
    @NotNull(message = "register_mode为空")
    @JsonProperty("register_mode")
    private String registerMode; // 注册模式 register 新注册 bind 绑定 register_login 注册并登录
    @JsonProperty("user_id")
    private Long userId; // 用户ID
    private String name; // 用户名称
    private String password; // 密码
    private String avatar; // 头像
    private String extension; // 扩展信息
    private String otpCode;

    public String getBindAccountListString() {
        List<accountList> accountListList = new ArrayList<>();
        accountListList.add(new accountList(this.identifyType, this.identifier));
        return accountListList.toString();
    }

    public static class accountList {
        accountList(Integer identifyType, String identifier) {
            this.identifyType = identifyType;
            this.identifier = identifier;
        }
        private Integer identifyType;
        private String identifier;
    }
}