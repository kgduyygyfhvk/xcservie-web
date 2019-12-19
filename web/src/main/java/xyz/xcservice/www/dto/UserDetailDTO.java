package xyz.xcservice.www.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wuwenchao
 * @create 2019/12/13
 */
@Data
public class UserDetailDTO implements Serializable {

    private static final long serialVersionUID = -3320522102447481534L;

    @NotBlank(message = "登录账号不能为空")
    private String loginCode;

    @NotBlank(message = "密码不能为空")
    private String password;

}
