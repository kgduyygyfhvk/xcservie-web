package xyz.xcservice.www.login.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import xyz.xcservice.www.login.entity.UserAuthoritiesPO;
import xyz.xcservice.www.login.mapper.UserAuthoritiesMapper;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author wuwenchao
 * @create 2019/12/13
 */
@Component
@Slf4j
public class LoginAuthenticationManager implements AuthenticationManager {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        UserDetails userDetails = userDetailsService.loadUserByUsername((String) authentication.getPrincipal());
        if (Objects.isNull(userDetails)) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        //将密码加密与库中的密码进行摘要碰撞
        String encPassword = bCryptPasswordEncoder.encode((String) authentication.getCredentials());
        if (bCryptPasswordEncoder.matches(encPassword,userDetails.getPassword())) {
            throw new AuthenticationServiceException("用户密码错误");
        }
        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(),
                userDetails.getAuthorities());
        return newAuthentication;
    }


}


