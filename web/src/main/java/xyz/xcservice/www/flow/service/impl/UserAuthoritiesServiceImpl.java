package xyz.xcservice.www.flow.service.impl;

import xyz.xcservice.www.flow.entity.UserAuthoritiesPO;
import xyz.xcservice.www.flow.mapper.UserAuthoritiesMapper;
import xyz.xcservice.www.flow.service.UserAuthoritiesService;
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
