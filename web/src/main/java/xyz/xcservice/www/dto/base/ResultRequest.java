package xyz.xcservice.www.dto.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wuwenchao
 * @create 2019/12/17
 **/
@Data
public class ResultRequest implements Serializable {

    @ApiModelProperty(value = "系统日志id")
    private String traceLogId;

    @ApiModelProperty(value = "请求系统")
    private String systemName;
}
