package xyz.xcservice.www.login.service.impl;

import xyz.xcservice.www.login.entity.UserAuthoritiesPO;
import xyz.xcservice.www.login.mapper.UserAuthoritiesMapper;
import xyz.xcservice.www.login.service.UserAuthoritiesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限表 服务实现类
 * </p>
 *
 * @author wuwenchao
 * @since 2019-12-20
 */
@Service
public class UserAuthoritiesServiceImpl extends ServiceImpl<UserAuthoritiesMapper, UserAuthoritiesPO> implements UserAuthoritiesService {

}
