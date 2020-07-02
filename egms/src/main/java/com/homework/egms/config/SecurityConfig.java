package com.homework.egms.config;

import com.homework.egms.exception.MyAuthenticationException;
import com.homework.egms.filter.JwtAuthTokenFilter;
import com.homework.egms.handler.MyAccessDeniedHandler;
import com.homework.egms.handler.MyAuthenticationFailureHandler;
import com.homework.egms.handler.MyAuthenticationSuccessHandler;
import com.homework.egms.service.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @program: egms
 * @description:配置自定义登录页面，当表单提交方式为post时，
 * 进行登录处理；制定请求的授权规则
 * @Author: Sherlock
 * @Date 2020/6/27 10:36
 */
@EnableWebSecurity //开启Web安全模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Spring会自动寻找同样类型的具体类注入，这里就是JwtUserDetailsServiceImpl了
    @Autowired
    MyUserDetailsService userDetailsService;
    //登录成功处理类，如返回自定义jwt
    @Autowired
    MyAuthenticationSuccessHandler authenticationSuccessHandler;
    //登录失败处理类
    @Autowired
    MyAuthenticationFailureHandler authenticationFailHandler;
    //token 过滤器，解析token
    @Resource
    private JwtAuthTokenFilter jwtAuthTokenFilter;
    //权限不足处理类
    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;
    //其他异常处理类
    @Autowired
    MyAuthenticationException myAuthenticationException;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                // 设置UserDetailsService 获取user对象
                .userDetailsService(this.userDetailsService);
    }
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void  configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .formLogin()
                .usernameParameter("userId").passwordParameter("password")
                .loginProcessingUrl("/user/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/user/*")
                .permitAll()
                .antMatchers("/admin/*")
                .hasAnyAuthority("ROLE_admin","ROLE_user")
              //  .anyRequest().authenticated()
                .and().exceptionHandling();
               // .authenticationEntryPoint(authenticationEntryPoint);
        httpSecurity.
                csrf().disable()//禁止跨站csrf攻击防御，否则无法登陆成功
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                // 对于获取token的rest api要允许匿名访问
                .antMatchers("/test/**").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();
        httpSecurity.
                headers().frameOptions().disable().cacheControl();//解决IFrame拒绝问题、禁用缓存
        // 添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置认证方式
        super.configure(auth);
    }

}
