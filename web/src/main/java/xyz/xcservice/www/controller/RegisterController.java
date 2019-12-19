//package xyz.xcservice.www.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;
//import xyz.xcservice.www.authorities.entity.UserAuthoritiesPO;
//import xyz.xcservice.www.dto.UserDetailDTO;
//import xyz.xcservice.www.dto.base.ResultResponse;
//import xyz.xcservice.www.enums.SystemResponseCodeEnum;
//import xyz.xcservice.www.login.entity.UserDetailPO;
//import xyz.xcservice.www.service.UserAuthoritiesService;
//import xyz.xcservice.www.service.UserDetailService;
//
//
///**
// * @author wuwenchao
// * @create 2019/11/10
// */
//@RestController
//@RequestMapping("/auth")
//@Slf4j
//@Api(value = "loginManage", description = "账号管理API")
//public class RegisterController {
//
//    @Autowired
//    private UserDetailService userDetailService;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private UserAuthoritiesService userAuthoritiesService;
//
//
//    @PostMapping("/register")
//    @ResponseBody
//    @ApiIgnore
//    @ApiOperation(value = "register", notes = "register", response = String.class )
//    public ResultResponse<Boolean> registerUser(@RequestBody UserDetailDTO userDetailDTO){
//        UserDetailPO userDetailPO = new UserDetailPO();
//        userDetailPO.setLoginCode(userDetailDTO.getLoginCode());
//        userDetailPO.setPassword(bCryptPasswordEncoder.encode(userDetailDTO.getPassword()));
//        boolean isSuccess = userDetailService.save(userDetailPO);
//        if (isSuccess){
//            log.info("[{}]用户登录表创建成功",userDetailDTO.getLoginCode());
//        }
//        QueryWrapper<UserDetailPO> queryWrapper = new QueryWrapper();
//        queryWrapper.eq("login_code",userDetailPO.getLoginCode());
//        UserDetailPO userDetailPO1 = userDetailService.get(queryWrapper);
//        UserAuthoritiesPO userAuthoritiesPO = new UserAuthoritiesPO();
//        userAuthoritiesPO.setUserDetailId(userDetailPO1.getId());
//        userAuthoritiesPO.setAuthority("USER");
//        userAuthoritiesService.save(userAuthoritiesPO);
//        return new ResultResponse<>(SystemResponseCodeEnum.SUCCESS);
//    }
//}
