package xyz.xcservice.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import xyz.xcservice.www.filter.JwtAuthorizationFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuwenchao
 * @date 2019/11/10
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 不拦截swagger路径
     */
    public static final List<String> IGNORE_PATHS;
    static {
        IGNORE_PATHS = new ArrayList<>();
        IGNORE_PATHS.add("/v2/api-docs");
        IGNORE_PATHS.add("/swagger-ui.html");
        IGNORE_PATHS.add("/swagger-resources/**");
        IGNORE_PATHS.add("/webjars/**");
    }


    /**
     * 设置防火墙
     *
     * @return
     */
    @Bean
    public StrictHttpFirewall httpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowedHttpMethods(Arrays.asList("GET", "POST"));
        return firewall;
    }

    /**
     * 跨域
     *
     * @return
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                //白名单路径
                .antMatchers("/login","/register","/swagger","/**.html").permitAll()
                .antMatchers(WebSecurityConfig.IGNORE_PATHS.toArray(new
                        String[WebSecurityConfig.IGNORE_PATHS.size()])).permitAll()
                //其他都要鉴权
                .antMatchers("/**").hasAnyAuthority("USER")
                .anyRequest().authenticated()
                .and()
                //鉴权过滤
                .addFilterBefore(new JwtAuthorizationFilter(), LogoutFilter.class)
                //不要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 授权异常处理
                .exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint())
                .accessDeniedHandler(new JwtAccessDeniedHandler());
    }
}
