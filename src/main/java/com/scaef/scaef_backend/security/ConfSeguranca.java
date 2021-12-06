package com.scaef.scaef_backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfSeguranca extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
                .and()
            .formLogin()
                .defaultSuccessUrl("/home", true)
                .permitAll()
                .and()
            .authorizeRequests()
                .antMatchers("/usuario/**")
                .permitAll();
    }

    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(12);
	}    
}
       /*.antMatchers("/css/**", "/js/**", "/resources/**").permitAll()
        .antMatchers("/usuario/**").hasAnyAuthority(EnumFuncao.Administrador.toString())
        .anyRequest().authenticated()
        .and()
        .formLogin(form -> form
                .loginPage("/login1")
                .defaultSuccessUrl("/home", true)
                .permitAll())
                .logout(logout -> logout.logoutUrl("/logout"))
                .csrf()
                .disable();*/