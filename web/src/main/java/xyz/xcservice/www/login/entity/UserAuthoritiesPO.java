package xyz.xcservice.www.login.entity;

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
 * 用户权限表
 * </p>
 *
 * @author wuwenchao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_authorities")
@ApiModel(value="UserAuthoritiesPO对象", description="用户权限表")
public class UserAuthoritiesPO extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户登录主键id")
    private Long userLoginId;

    @ApiModelProperty(value = "用户权限")
    private String authority;

    @ApiModelProperty(value = "备注")
    private String remark;

}
