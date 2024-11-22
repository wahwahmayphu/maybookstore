package com.example.bookstore.config;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var user1= User.withUsername("may")
                .password("1234")
                .roles("ADMIN")
                .build();
        var user2=User.withUsername("user")
                .password("1234")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,
                user2);
    }
    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        http.formLogin( c -> c.loginPage("/login").permitAll());
         http.logout( c -> c.logoutUrl("/logout").logoutSuccessUrl("/login").permitAll());

        http.authorizeHttpRequests(c -> {
            c.requestMatchers("/")         //.requestMatchers("/").permitAll()
                    .hasAnyRole("ADMIN", "USER")

                    .requestMatchers("/book_register","/save",
                            "/edit/{id}","/search","/available_books").hasAnyRole("ADMIN","USER")
                    .requestMatchers("/deleteBook/{id}").hasRole("ADMIN")
                    .anyRequest().authenticated();
        });
        http.csrf(c -> c.disable());
        return http.build();


    }







}


