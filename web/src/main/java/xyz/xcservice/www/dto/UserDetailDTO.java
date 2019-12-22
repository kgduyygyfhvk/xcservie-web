package xyz.xcservice.www.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xyz.xcservice.www.dto.base.ResultRequest;

import javax.validation.constraints.NotBlank;

/**
 * @author wuwenchao
 * @create 2019/12/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserDetailDTO extends ResultRequest {

    private static final long serialVersionUID = -3320522102447481534L;

    @NotBlank(message = "登录账号不能为空")
    @ApiModelProperty("登录账号")
    private String loginCode;

    @NotBlank(message = "登录密码不能为空")
    @ApiModelProperty("登录密码")
    private String password;

}
