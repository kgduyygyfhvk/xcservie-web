package xyz.xcservice.www.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import xyz.xcservice.www.base.ResultResponse;
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
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        String jsonStr = JSONObject.toJSONString(new ResultResponse<Void>(String.valueOf(HttpStatus.FORBIDDEN.value()),
                HttpStatus.FORBIDDEN.getReasonPhrase()), SerializerFeature.WriteMapNullValue);
        log.error("校验账号密码出错{}",jsonStr);
        log.error("\n{}", Throwables.getStackTraceAsString(accessDeniedException));
        ResponseUtil.writer(response,jsonStr);

    }
}
