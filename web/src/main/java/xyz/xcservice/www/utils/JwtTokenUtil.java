package xyz.xcservice.www.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuwenchao
 * @create 2019/11/10
 */
public class JwtTokenUtil {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    private static final String SECRET = "cesauthdemo";
    private static final String ISS = "cesiss";
    private static final String JWT = "jwt";
    private static final String TYP = "typ";
    private static final String ROLE = "role";
    /**
     * 过期时间1个小时,毫秒
     */
    private static long EXPIRATION = 3600L * 1000;

    /**
     * 创建token
     *
     * @param loginCode
     * @return
     */
    public static String createToken(String loginCode, List<SimpleGrantedAuthority> roleSet) {
        return Jwts.builder()
                .setHeaderParam(JwtTokenUtil.TYP, JwtTokenUtil.JWT)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .claim(JwtTokenUtil.ROLE, roleSet.parallelStream().map(SimpleGrantedAuthority::toString).collect(Collectors.joining(",")))
                .setIssuer(ISS)
                .setSubject(loginCode)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .compact();
    }


    /**
     * 从token中获取用户名
     *
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    /**
     * 是否已过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    /**
     * 解码token
     *
     * @param token
     * @return
     */
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 获取用户所有角色
     */
    public static Set<SimpleGrantedAuthority> getUserRolesByToken(String token) {

        String role = (String) getTokenBody(token).get(JwtTokenUtil.ROLE);
        if(StringUtils.isBlank(role)){
            return null;
        }
        return Arrays.stream(role.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

}
