package com.demo.demonstration.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
    private AuthenticationFailureHandler authFailureHandler;
	
	@Value("${user1}")
	private String user1;
	
	@Value("${password1}")
	private String password1;
	
	@Value("${role1}")
	private String role1;
	
	@Value("${user2}")
	private String user2;
	
	@Value("${password2}")
	private String password2;
	
	@Value("${role2}")
	private String role2;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	

	//Create Users
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser(user1).password(passwordEncoder().encode(password1)).roles(role1)
		.and()
		.withUser(user2).password(passwordEncoder().encode(password2)).roles(role2);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/error","/productAddition").permitAll()
				.antMatchers("/dashboard","/addProducts").hasAnyRole("admin","user")
				.and()
				.formLogin().loginPage("/login").permitAll().usernameParameter("username").passwordParameter("password").failureHandler(authFailureHandler)
				.and()
				.logout().permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index");
	}
	
	
	
	
	
	
}
