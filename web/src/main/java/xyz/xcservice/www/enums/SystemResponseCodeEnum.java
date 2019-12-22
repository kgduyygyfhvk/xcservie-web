package xyz.xcservice.www.enums;

import lombok.Getter;

/**
 * 系统错误码
 *
 * @author wuwenchao
 * @create 2019/12/16
 **/
@Getter
public enum SystemResponseCodeEnum {
    /**
     * 000000  成功
     * 999999  系统异常
     * 88      业务
     */


    SUCCESS("000000", "成功"),
    SYSTEM_ERROR("999999", "系统错误"),
    LOGIN_CODE_ALREADY_EXIST("880001", "用户已存在");

    /**
     * 系统前缀
     */
    public static final String PREFIX = "XC";

    SystemResponseCodeEnum(String code, String message) {
        this.code = PREFIX + code;
        this.message = message;
    }

    public static SystemResponseCodeEnum getMessage(String code) {
        for (SystemResponseCodeEnum systemResponseCodeEnum : values()) {
            if (systemResponseCodeEnum.getCode().equals(code)) {
                return systemResponseCodeEnum;
            }
        }
        return null;
    }

    /**
     * 响应码
     */
    private String code;
    /**
     * 信息
     */
    private String message;


}
