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
import com.cook.talk.model.serviceImpl.UserServiceImpl;

@Configuration
@EnableWebSecurity
//@EnableWebSecurity=시큐리티 설정할 클래스라 정의 
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

   @Autowired
   private UserServiceImpl userDetailsService;

   @Autowired
   private Handler handler;

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }// PasswordEncoder: BCryptPasswordEncoder는 시큐리티에서 제공하는 비밀번호 암호화 객체 -BEAN으로 등록.

   @Override
   public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/res/**");
   }// configure를 오버라이딩하여 시큐리티 설정을 잡아준다.
//WebSecurity는 FilterChainProxy를 생성하는 필터.
 

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http .authorizeRequests() //페이지 권한 설정
                  
                    .antMatchers("/user/mypage").hasRole("Role_MEMBER")
				/* .antMatchers("/admin/**","/adminMain/**").hasRole("Role_ADMIN") */
				
                    .antMatchers("/**/","/login","/index","/join","/ingrSelect","/chefInfo","/chefRank"
                    		,"/loginIndex","/adminMain/**","/admin/**","/chosung","/searched", "/rcmmRecipe", "/mypage/**","/chat/**").permitAll()
                    .antMatchers("/admin/**","/adminMain/**").hasRole("Role_ADMIN")
                    .antMatchers("/user/mypage").hasRole("MEMBER")
                    .anyRequest().authenticated();
                    
                    

        //접근 가능 
                 //  .anyRequest().authenticated();
                // .antMatchers("/**").authenticated();
                //인증 필요로 함. 

                    http
                    //.and()//로그인 설정 
                    .csrf()
                    .disable();
                 
                    http
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/index")
                    .permitAll()
                    
                    .and()
                   .logout()
                   .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                   .logoutSuccessUrl("/user/logout/result");
					/*
					 * http .csrf().disable() // 기본값이 on인 csrf 취약점 보안을 해제한다. on으로 설정해도 되나 설정할경우
					 * 웹페이지에서 추가처리가 필요함. .headers() .frameOptions().sameOrigin() // SockJS는 기본적으로
					 * HTML iframe 요소를 통한 전송을 허용하지 않도록 설정되는데 해당 내용을 해제한다. .and() .formLogin() //
					 * 권한없이 페이지 접근하면 로그인 페이지로 이동한다. .and() .authorizeRequests()
					 * .antMatchers("/chat/**") // chat으로 시작하는 리소스에 대한 접근 권한 설정 .permitAll();
					 */
    // .defaultSuccessUrl("/main");
    }

  
    
    
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          //spring Security에서 모든 인증은 AuthenticationManager를 통해 이루어지며 
           //AuthenticationManager를 생성하기 위해서는 AuthenticationManagerBuilder를 사용.
           auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }


    
}