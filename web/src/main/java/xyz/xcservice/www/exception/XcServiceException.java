package xyz.xcservice.www.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import xyz.xcservice.www.enums.SystemResponseCodeEnum;

/**
 * 异常处理类
 * @author wuwenchao
 * @date 2019/12/17
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
public class XcServiceException extends RuntimeException{

    private SystemResponseCodeEnum systemResponseCodeEnum;

    public XcServiceException(String msg) {
        super(msg);
    }

    public XcServiceException(String msg, Throwable t) {
        super(msg, t);
    }

    public XcServiceException(SystemResponseCodeEnum systemResponseCodeEnum) {
        super(systemResponseCodeEnum.getMessage());
        this.systemResponseCodeEnum = systemResponseCodeEnum;
    }

}
