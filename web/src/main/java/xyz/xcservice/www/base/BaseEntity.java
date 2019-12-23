package xyz.xcservice.www.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wuwenchao
 * @create 2019/11/10
 */
@Data
public class BaseEntity{

    private static final long serialVersionUID = -5211466388436752649L;

    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;

    @ApiModelProperty(value = "创建名称")
    private String createBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateAt;

    @ApiModelProperty(value = "更新名称")
    private String updateBy;
}
