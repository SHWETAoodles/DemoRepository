package com.Emp.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
 @Override
	protected void configure(HttpSecurity http) throws Exception{
	 //we disable csrf when non browsing application using API
	 http
	      .csrf().disable()
	      .authorizeRequests()
	      .antMatchers("/public/**").hasRole("NORMAL")
	      .antMatchers("/training/**").hasRole("ADMIN")
	      .anyRequest()
	      .authenticated()
	      .and()
	      .httpBasic();
	 
 }
 @Override
 protected void configure(AuthenticationManagerBuilder auth)throws Exception{
	auth.inMemoryAuthentication().withUser("shwetasingh").password(this.passwordEncoder().encode("14024")).roles("NORMAL");
	auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("oodless")).roles("ADMIN");
	 
 }
// @SuppressWarnings("deprecation")
@Bean
 public PasswordEncoder passwordEncoder() {
	 return new BCryptPasswordEncoder(10);
	
	 
 }
 
 
 
}
