package entity;


import lombok.Data;
import net.sf.oval.constraint.NotNull;

@Data
public class RegisterDto {
    @NotNull(message = "source为空")
    private String source; // 来源
    private String userId; // 用户ID
    private String name; // 用户名称
    private String identifier; // 账号名称
    private Integer identifyType; // 账号类型
    private String password; // 密码
    private String avatar; // 头像
    private String extension; // 扩展信息
    private String registerMode; // 注册模式 register 新注册 bind 绑定 register_login 注册并登录
    private String otpCode;
}