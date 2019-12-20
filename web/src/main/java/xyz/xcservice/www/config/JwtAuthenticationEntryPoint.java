package xyz.xcservice.www.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import xyz.xcservice.www.base.ResultResponse;
import xyz.xcservice.www.enums.SystemResponseCodeEnum;
import xyz.xcservice.www.utils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wuwenchao
 * @date 2019/12/17
 */
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        String jsonStr = JSONObject.toJSONString(new ResultResponse<Void>(SystemResponseCodeEnum.SYSTEM_ERROR.getCode(),
                authException.getMessage()), SerializerFeature.WriteMapNullValue);
        log.error("校验账号登录错误:{}",jsonStr);
        log.error("\n{}", Throwables.getStackTraceAsString(authException));
        ResponseUtil.writer(response,jsonStr);

    }
}