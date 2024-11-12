package com.Astefil_Inflables.Catalogo.Backend.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/admin/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/article/**").permitAll()
                        .requestMatchers("/api/article/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/auth/login/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/category/**").permitAll()
                        .requestMatchers("/api/category/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/image/**").permitAll()
                        .requestMatchers("/api/image/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/user/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/user_query/**").permitAll()
                        .requestMatchers("/api/user_query/**").hasAnyAuthority("ADMIN", "EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/zone/**").permitAll()
                        .requestMatchers("/api/zone/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                );
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}