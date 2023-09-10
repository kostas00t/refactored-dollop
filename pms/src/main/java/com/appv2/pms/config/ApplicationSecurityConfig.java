package com.appv2.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User
				.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();

		UserDetails user = User
				.withUsername("user")
				.password(passwordEncoder().encode("password"))
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	        http
	        .authorizeHttpRequests()
	        .anyRequest()
	        .authenticated()
	            .and()
	            .formLogin()
	            .and()
	            .httpBasic();        
	        
	        http.csrf().disable();
	}

}