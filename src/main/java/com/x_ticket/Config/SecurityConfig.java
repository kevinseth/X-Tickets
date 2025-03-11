package com.x_ticket.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // APIs typically disable CSRF
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                // Allow Swagger UI and API docs access without authentication
                                .requestMatchers("/swagger-ui.html", "/swagger-ui/**",
                                        "/v3/api-docs/**", "/swagger-resources/**",
                                        "/webjars/**","/api/user/register","/api/email/send").permitAll()
                                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                                .requestMatchers("/api/protocol/**").hasRole("PROTOCOL")
                                .requestMatchers("/api/user/**").hasRole("USER")
                                .anyRequest().authenticated()
                )
                // Use appropriate authentication for API (JWT, OAuth2, etc.)
                .oauth2Login(oauth2 -> oauth2.userInfoEndpoint(
                        userInfo -> userInfo.userService(oauth2UserService())
                ));

        return http.build();
    }


    @Bean
    public DefaultOAuth2UserService oauth2UserService() {
        return new DefaultOAuth2UserService();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
}