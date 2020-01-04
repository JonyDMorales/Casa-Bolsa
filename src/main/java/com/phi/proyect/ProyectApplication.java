package com.phi.proyect;

import com.phi.proyect.configure.JWTAuthorizationFilter;
import com.phi.proyect.controller.HomeController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class ProyectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectApplication.class, args);
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .cors().and()
                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/admin/**").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST, "/phiinvestment/login").permitAll()
                    .anyRequest().authenticated().and().formLogin()
                    .failureUrl("/fault")
                    .defaultSuccessUrl("/limiteslineas",true);
        }
    }
}
