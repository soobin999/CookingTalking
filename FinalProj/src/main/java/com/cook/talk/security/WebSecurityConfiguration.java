package com.cook.talk.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.cook.talk.model.service.UserService;


@Configuration
@EnableWebSecurity
//@EnableWebSecurity=시큐리티 설정할 클래스라 정의 
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

@Autowired
private UserService userDetailsService;
@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}//PasswordEncoder: BCryptPasswordEncoder는 시큐리티에서 제공하는 비밀번호 암호화 객체 -BEAN으로 등록.
@Override
public void configure(WebSecurity web) throws Exception{
	web.ignoring().antMatchers("/css/**","/js/**","/img/**","/lib/**");
}//configure를 오버라이딩하여 시큐리티 설정을 잡아준다.
//WebSecurity는 FilterChainProxy를 생성하는 필터.

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http .authorizeRequests() //페이지 권한 설정
                    .antMatchers("/login","/index","/join","/ingrSelect","/chefInfo","/chefRank","/loginIndex").permitAll()
                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/user/mypage").hasRole("MEMBER")
                    .anyRequest().authenticated()
                    
                    .and()//로그인 설정 
                    .csrf()
                    .disable()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/index")
                    .permitAll()
                    
                    .and()
                   .logout()
                   .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                   .logoutSuccessUrl("/user/logout/result");
                   http.csrf().disable();
    // .defaultSuccessUrl("/main");
    }

      
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          //spring Security에서 모든 인증은 AuthenticationManager를 통해 이루어지며 
        	//AuthenticationManager를 생성하기 위해서는 AuthenticationManagerBuilder를 사용.
        	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }

      
    }

    

