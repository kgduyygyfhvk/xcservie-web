package xyz.xcservice.www.flow.service.impl;

import xyz.xcservice.www.flow.entity.UserLoginPO;
import xyz.xcservice.www.flow.mapper.UserLoginMapper;
import xyz.xcservice.www.flow.service.UserLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
