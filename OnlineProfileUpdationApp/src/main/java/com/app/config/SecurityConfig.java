package com.app.config;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.app.service.impl.UserDetailsServiceImpl;



@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;	
	
	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("profileApp/**")).and().authorizeRequests()
		.antMatchers("profileApp/users/error").permitAll()
		.antMatchers("profileApp/users/logout").permitAll()
		.antMatchers("/css/**",
				"/images/**",
				"/templates/**").permitAll()
		.antMatchers("profileApp/Admin/**").hasRole("ADMIN")
		.antMatchers("profileApp/employee/**").hasRole("USER")
		.anyRequest().authenticated()
		.and().formLogin()  
        .loginPage("/profileApp/users/login").permitAll()
        .loginProcessingUrl("/app-login")
        .usernameParameter("app_username")
        .passwordParameter("app_password")
        .successHandler(successHandler)	
		.and().logout()
		.deleteCookies("JSESSIONID")
		.and().exceptionHandling()
		.accessDeniedPage("/profileApp/users/error");
		
	
	} 
	
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
       auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
	}
}