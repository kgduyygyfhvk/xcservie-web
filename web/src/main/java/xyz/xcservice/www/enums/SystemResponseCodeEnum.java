package xyz.xcservice.www.enums;

import lombok.Getter;

/**
 * 系统错误码
 * @author wuwenchao
 * @create 2019/12/16
 **/
@Getter
public enum SystemResponseCodeEnum {
    /**
     * 000000  成功
     * 999999  系统异常
     */


    SUCCESS("000000","成功"),
    SYSTEM_ERROR("999999","系统错误");

    /**
     * 系统前缀
     */
    public static final String PREFIX = "XC";

    SystemResponseCodeEnum(String code, String message) {
        this.code = PREFIX + code;
        this.message = message;
    }
    /**
     * 响应码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    @Override
    public String toString() {
        return "SystemResponseCodeEnum{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }}
