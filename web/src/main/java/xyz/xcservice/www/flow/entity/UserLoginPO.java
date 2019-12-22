package xyz.xcservice.www.flow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import xyz.xcservice.www.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户登录表
 * </p>
 *
 * @author wuwenchao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_login")
@ApiModel(value="UserLoginPO对象", description="用户登录表")
public class UserLoginPO extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户账号")
    private String loginCode;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "登录次数")
    private Long loginCount;

    @ApiModelProperty(value = "登录最后时间")
    private LocalDateTime loginLastTime;

    @ApiModelProperty(value = "账号是否过期")
    private Boolean accountNonExpired;

    @ApiModelProperty(value = "账号是否被锁")
    private Boolean accountNonLocked;

    @ApiModelProperty(value = "密码是否过期")
    private Boolean credentialsNonExpired;

    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    @ApiModelProperty(value = "备注")
    private String remark;
}
