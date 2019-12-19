//package xyz.xcservice.www.config;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import xyz.xcservice.www.dto.base.ResultResponse;
//import xyz.xcservice.www.utils.ResponseUtil;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author wuwenchao
// * @date 2019/12/17
// */
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//
//        String jsonStr = JSONObject.toJSONString(new ResultResponse<Void>(HttpStatus.UNAUTHORIZED), SerializerFeature.WriteMapNullValue);
//        ResponseUtil.writer(response,jsonStr);
//
//    }
//}
