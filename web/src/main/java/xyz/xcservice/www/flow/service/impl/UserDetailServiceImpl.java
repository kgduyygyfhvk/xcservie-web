package xyz.xcservice.www.flow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.xcservice.www.dto.UserLoginDetails;
import xyz.xcservice.www.flow.entity.UserAuthoritiesPO;
import xyz.xcservice.www.flow.entity.UserLoginPO;
import xyz.xcservice.www.flow.mapper.UserAuthoritiesMapper;
import xyz.xcservice.www.flow.mapper.UserLoginMapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wuwenchao
 * @since 2019-11-10
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserLoginMapper userLoginMapper;
    @Resource
    private UserAuthoritiesMapper userAuthoritiesMapper;

    @Override
    public UserDetails loadUserByUsername(String loginCode) throws UsernameNotFoundException {
        LambdaQueryWrapper<UserLoginPO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(UserLoginPO::getLoginCode,loginCode);
        UserLoginPO userDetail = userLoginMapper.selectOne(lambdaQueryWrapper);
        if (Objects.isNull(userDetail)){
            return null;
        }
        QueryWrapper<UserAuthoritiesPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_login_id",userDetail.getId());
        List<UserAuthoritiesPO> authList =  userAuthoritiesMapper.selectList(queryWrapper);
        return new UserLoginDetails(userDetail,authList.parallelStream().map(role->new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList()));
    }
}
