package xyz.xcservice.www.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import xyz.xcservice.www.utils.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author wuwenchao
 * @create 2019/11/10
 */
@Slf4j
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    /**
     * 做过滤
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        //获取token头
        String tokenHeader = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        //判断请求头是否存在Authorization和判断请求头是否存在Bearer或者为登录路径直接放行
        if (StringUtils.isBlank(tokenHeader) || !tokenHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            //不给与权限放行，Security会拦截没授权的请求
            chain.doFilter(request, response);
            return;
        }
        //给与权限
        Authentication authentication = getAuthentication(tokenHeader);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    /**
     * 这里从token中获取用户信息并新建
     * 一个UsernamePasswordAuthenticationToken token
     *
     * @param tokenHeader
     * @return
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String token = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "").trim();
        //获取用户名
        String loginCode = JwtTokenUtil.getUsername(token);
        boolean isExpire = JwtTokenUtil.isExpiration(token);
        Set<SimpleGrantedAuthority> authoritySet = JwtTokenUtil.getUserRolesByToken(token);
        if (StringUtils.isNotBlank(loginCode) && !isExpire) {
            return new UsernamePasswordAuthenticationToken(loginCode, null, authoritySet);
        }
        return null;
    }
}
