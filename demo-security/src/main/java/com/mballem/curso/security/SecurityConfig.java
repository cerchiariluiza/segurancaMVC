package com.mballem.curso.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    
		http.authorizeRequests()
		// acessos públicos liberados
		.antMatchers("/webjars/**", "/css/**", "/image/**", "/js/**").permitAll()
		.antMatchers("/login", "/home").permitAll()
		
		.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/", true)
			.failureUrl("/login-error")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/");
}

}



