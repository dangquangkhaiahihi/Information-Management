package com.InformationManagement.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/","index","/css/").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
				.loginPage("/logout").permitAll()//custom login page
				.defaultSuccessUrl("")//custom success landing page
				.and()
				.rememberMe()
			.and()
			.logout()
				.logoutUrl("")//custom logout url
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID","remember-me")
				.logoutSuccessUrl("");//custom logout success landing page
		
	}
	
//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//	}
}
