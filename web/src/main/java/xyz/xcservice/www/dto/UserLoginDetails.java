package xyz.xcservice.www.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.xcservice.www.login.entity.UserLoginPO;

import java.util.Collection;

/**
 * @author wuwenchao
 * @date 2019/12/20
 */
public class UserLoginDetails implements UserDetails {

    private UserLoginPO userLoginPO;

    private Collection<? extends GrantedAuthority> authorities;

    public UserLoginDetails(UserLoginPO userLoginPO,Collection<? extends GrantedAuthority> authorities){
        this.userLoginPO = userLoginPO;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return userLoginPO.getPassword();
    }

    @Override
    public String getUsername() {
        return userLoginPO.getLoginCode();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userLoginPO.getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userLoginPO.getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userLoginPO.getCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userLoginPO.getEnabled();
    }
}
