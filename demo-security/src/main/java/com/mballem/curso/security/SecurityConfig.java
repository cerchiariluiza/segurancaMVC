package com.mballem.curso.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    //Rodar e ver que com barra funciona
		http.authorizeRequests()
		.antMatchers("/home", "/webjars/**", "/", "/css/**", "/image/**").permitAll()
		.anyRequest().authenticated();
		
	}

}
