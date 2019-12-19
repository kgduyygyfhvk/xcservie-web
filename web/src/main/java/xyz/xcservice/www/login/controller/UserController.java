package xyz.xcservice.www.login.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import xyz.xcservice.www.base.ResultResponse;
import xyz.xcservice.www.dto.UserDetailDTO;

import javax.annotation.Resource;

/**
 * <p>
 * 用户登录表 前端控制器
 * </p>
 *
 * @author wuwenchao
 * @since 2019-12-20
 */
@RestController
@Slf4j
@Api(value = "loginManage", description = "账号管理API")
public class UserController {

    @Resource
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    @ResponseBody
    @ApiIgnore
    @ApiOperation(value = "login", notes = "login", response = String.class)
    public ResultResponse<String> login(UserDetailDTO userDetailDTO){
        log.info("开始验证登录账号:[{}]", userDetailDTO.getLoginCode());
        //开始验证账号密码
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDetailDTO.getLoginCode(), userDetailDTO.getPassword())
        );
        log.info("验证成功:[{}]", userDetailDTO.getLoginCode());
        return new ResultResponse<>("");
    }

}

