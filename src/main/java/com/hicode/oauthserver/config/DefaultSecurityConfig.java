package com.hicode.oauthserver.config;

import com.hicode.oauthserver.service.CustomAuthenticaitonProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class DefaultSecurityConfig {

	@Autowired
	private CustomAuthenticaitonProvider customAuthenticaitonProvider;
	
	 @Bean
	    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	        http.authorizeRequests(authorizeRequests ->
	                        authorizeRequests.anyRequest().authenticated()
	                )
	                .formLogin(Customizer.withDefaults());
	        return http.build();
	    }
	 
	 @Autowired
	 public void bindAuthenticaitonProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
		 authenticationManagerBuilder.authenticationProvider(customAuthenticaitonProvider);
	 }
	 
}
