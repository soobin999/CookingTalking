package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity // 시큐리티에서 설정해주는 기본 설정 날아간다고 생각

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		//어떻게 보안을 걸지 설정하는 것
		.antMatchers("/","home").permitAll()
		.anyRequest().authenticated()//나머지는 인증이 필요하다. 
		
		.and()
		.formLogin()//인증이 안된 아이들이 가는 곳 
		.loginPage("/login")//로그인 페이지로 가는것 
		.permitAll()
		
		.and()
		.logout()
		.logoutSuccessUrl("/home")
		.permitAll();		
	}
	
		//
		
	//return super.userDetailsService();//따로 만들어서 빈으로 사용 
}

/*테스트 용도 
 * @Bean
 * 
 * @Override protected UserDetailsService userDetailsService() { UserDetails
 * user= User.withDefaultPasswordEncoder() .username("user")
 * .password("password") .roles("USER") .build();
 * 
 * return new InMemoryUserDetailsManager(user);
 * 
 */