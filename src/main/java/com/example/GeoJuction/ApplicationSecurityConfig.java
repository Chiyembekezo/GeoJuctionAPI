package com.example.GeoJuction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.GeoJuction.security.restapi.jwtconfig.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
 

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .authorizeHttpRequests()
            .requestMatchers("/login", "/resources/**", "/assets/**", "/bootstrap/**", "/sass/**", "/plugins/**", "/img/**").permitAll()
            .requestMatchers("/register", "/resources/**", "/assets/**", "/bootstrap/**", "/sass/**", "/plugins/**", "/img/**").permitAll()
            .requestMatchers("/ticket/ticketTypes/**").hasAnyAuthority("ADMIN")
            .requestMatchers("/ticket/tickets/**").hasAnyAuthority("ADMIN", "ACCOUNTANT")
            .requestMatchers("/report/**").hasAnyAuthority("ADMIN", "ACCOUNTANT")
            .requestMatchers("/wallet/**").hasAnyAuthority("ADMIN")
            .requestMatchers("/security/**").hasAuthority("ADMIN")
            .requestMatchers("/api/v1/auth/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .formLogin()  // Add formLogin() configuration here
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/")
            .and()
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .logout()  // Continue with the existing configuration
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/accessDenied");

        return http.build();
    }


    
}
