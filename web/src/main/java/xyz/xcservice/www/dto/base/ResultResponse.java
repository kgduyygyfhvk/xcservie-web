package xyz.xcservice.www.dto.base;

import lombok.Data;
import xyz.xcservice.www.enums.SystemResponseCodeEnum;

/**
 * 返回结果类
 * @author wuwenchao
 * @create 2019/12/16
 **/
@Data
public class ResultResponse<T>{


    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 返回数据json
     */
    private T data;

    /**
     * 判断接口是否异常
     */
    private boolean success;

    public ResultResponse() {
        this.errorCode = SystemResponseCodeEnum.SUCCESS.getCode();
        this.errorMsg = SystemResponseCodeEnum.SUCCESS.getCode();
        this.success = true;
    }

    public ResultResponse(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.success = false;
    }

    public ResultResponse(SystemResponseCodeEnum systemResponseCodeEnum) {
        this.errorCode = systemResponseCodeEnum.getCode();
        this.errorMsg = systemResponseCodeEnum.getMessage();
        this.success = false;
    }

    public ResultResponse(T data) {
        this.errorCode = SystemResponseCodeEnum.SUCCESS.getCode();
        this.errorMsg = SystemResponseCodeEnum.SUCCESS.getMessage();
        this.data = data;
        this.success = true;
    }

}
