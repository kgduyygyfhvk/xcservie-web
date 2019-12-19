package xyz.xcservice.www.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import xyz.xcservice.www.base.ResultResponse;
import xyz.xcservice.www.dto.UserDetailDTO;
import xyz.xcservice.www.enums.SystemResponseCodeEnum;
import xyz.xcservice.www.exception.XcServiceException;
import xyz.xcservice.www.utils.JwtTokenUtil;
import xyz.xcservice.www.utils.ResponseUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Set;

/**
 * @author wuwenchao
 * @create 2019/11/10
 */
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    @Autowired
    private Validator validator;

    public static final String loginUrl ="/auth/login";

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        //登录路径
        super.setFilterProcessesUrl(loginUrl);
    }


    /**
     * 登陆得时候会call this function
     *
     * @param request  请求service
     * @param response 响应reponse
     * @return 返回Authentication类型
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserDetailDTO userDetailDTO = new ObjectMapper().readValue(request.getInputStream(), UserDetailDTO.class);
            log.info("开始验证登录账号:[{}]", userDetailDTO.getLoginCode());
            //开始验证账号密码
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDetailDTO.getLoginCode(), userDetailDTO.getPassword())
            );
            return authentication;
        } catch (Exception e) {
            log.error("异常处理{}", Throwables.getStackTraceAsString(e));
            throw new XcServiceException(SystemResponseCodeEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 登录校验完用户名和密码之后，call this function
     *
     * @param request
     * @param response
     * @param chain
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication) throws IOException, ServletException {

        String loginCode = (String) authentication.getPrincipal();
        //创建token
        String token = JwtTokenUtil.createToken(loginCode,(Set)authentication.getAuthorities());
        // 按照jwt的规定，最后请求的格式应该是 `Bearer<token>`
        log.info("验证成功[{}]", loginCode);
        String jsonStr = JSONObject.toJSONString(new ResultResponse(JwtTokenUtil.TOKEN_PREFFIEX + token), SerializerFeature.WriteMapNullValue);
        ResponseUtil.writer(response, jsonStr);
    }

    /**
     * call this function when failed.
     *
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        String jsonStr = JSONObject.toJSONString(new ResultResponse<Void>("999999",failed.getMessage()), SerializerFeature.WriteMapNullValue);
        ResponseUtil.writer(response, jsonStr);
    }

}
