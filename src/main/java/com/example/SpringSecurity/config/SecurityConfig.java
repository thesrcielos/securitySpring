package com.example.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //configuration one
    /*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.
                authorizeHttpRequests(
                    auth -> auth.requestMatchers("/api/index2").permitAll()
                            .anyRequest().authenticated()
                ).formLogin(AbstractAuthenticationFilterConfigurer::permitAll).
                build();
    }

     */
    //configuration two
    @Bean
    public  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.
                authorizeHttpRequests(
                        auth -> auth.requestMatchers("/api/index2").permitAll()
                                .anyRequest().authenticated()
                ).formLogin(form ->
                        form.successHandler(succesHandler()).permitAll()).
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)).
                build();
    }

    private AuthenticationSuccessHandler succesHandler() {
        return ((request, response, authentication) -> response.sendRedirect("api/index"));
    }


}
