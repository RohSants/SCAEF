package com.scaef.security;

/*import com.scaef.scaef_backend.enums.EnumFuncao;*/

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
                .loginPage("/login")
                /*.defaultSuccessUrl("/home", true)
                a home precisa de implementações de consultas*/
                .defaultSuccessUrl("/paciente/cadastro", true)
                .permitAll()
                .and()
            .authorizeRequests()
                .antMatchers("/usuario/**")
                .permitAll()
                .and()
            .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .and()
            .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/resources/**").permitAll();
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