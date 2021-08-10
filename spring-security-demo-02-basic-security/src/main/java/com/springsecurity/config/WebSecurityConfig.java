package com.springsecurity.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder user = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(user.username("Huy").password("123").roles("EMPLOYEE"))
			.withUser(user.username("Ngan").password("123").roles("MANAGER"))
			.withUser(user.username("Quyen").password("123").roles("ADMIN"));
	}
}
