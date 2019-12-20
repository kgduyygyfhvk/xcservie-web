package xyz.xcservice.www.login.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import xyz.xcservice.www.base.ResultResponse;
import xyz.xcservice.www.login.entity.UserLoginPO;
import xyz.xcservice.www.login.mapper.UserLoginMapper;
import xyz.xcservice.www.login.service.UserLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.xcservice.www.utils.JwtTokenUtil;
import xyz.xcservice.www.utils.ResponseUtil;

import javax.annotation.Resource;
import java.util.Set;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author wuwenchao
 * @since 2019-12-20
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLoginPO> implements UserLoginService {


}
