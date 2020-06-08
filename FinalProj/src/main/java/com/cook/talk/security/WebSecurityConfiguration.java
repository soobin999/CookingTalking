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

import com.cook.talk.model.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
private UserService userDetailsService;
@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
@Override
public void configure(WebSecurity web) throws Exception{
	web.ignoring().antMatchers("/css/**","/js/**","/img/**","/lib/**");
}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http .authorizeRequests() //페이지 권한 설정
                    .antMatchers("/**").permitAll()
                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/user/mypage").hasRole("MEMBER")
                     .anyRequest().authenticated()
                    
                     .and()//로그인 설정 
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/index")
                   // .defaultSuccessUrl("/index")
                //.loginProcessingUrl("/loginProcess")
                  
                    .permitAll()
                    
                    .and()
                .logout();
        http.csrf().disable();
    // .defaultSuccessUrl("/main");
    }

      
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }

      
    }

    
    
    

