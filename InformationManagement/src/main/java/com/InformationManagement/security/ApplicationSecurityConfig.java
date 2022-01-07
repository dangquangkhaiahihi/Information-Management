package com.InformationManagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.InformationManagement.auth.UserPrincipalService;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PasswordEncoder passwordEncoder;
	private final UserPrincipalService userPrincipalService;
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, UserPrincipalService userPrincipalService) {
		this.passwordEncoder = passwordEncoder;
		this.userPrincipalService = userPrincipalService;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
//			.antMatchers("/","index","/css/").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin();
//				.loginPage("/logout").permitAll()//custom login page
//				.defaultSuccessUrl("")//custom success landing page
//				.and()
//				.rememberMe()
//			.and()
//			.logout()
//				.logoutUrl("")//custom logout url
//				.clearAuthentication(true)
//				.invalidateHttpSession(true)
//				.deleteCookies("JSESSIONID","remember-me")
//				.logoutSuccessUrl("");//custom logout success landing page
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	protected DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(userPrincipalService);
		
		return provider;
	}
}
