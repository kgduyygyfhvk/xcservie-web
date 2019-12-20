package xyz.xcservice.www.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author wuwenchao
 * @create 2019/11/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BaseEntity extends ResultRequest {

    private static final long serialVersionUID = -5211466388436752649L;

    @ApiModelProperty(value = "用户登录主键id")
    private Long id;
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateAt;
    @ApiModelProperty(value = "修改人")
    private String updateBy;
}
