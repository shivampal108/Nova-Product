package com.product.hub.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityFilters {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) {
		
		
		security.
		csrf(csrf -> csrf.disable()).  cors(cors -> cors.configurationSource(corsConfigurationSource()))

		
		.authorizeHttpRequests(auth->
		 auth

         .requestMatchers("/api-auth/login", "/api-auth/login/**")
         .permitAll().		requestMatchers("/api-user/add").permitAll()
		.anyRequest().authenticated()
		
				
				
				)
		.sessionManagement(session->
		
		session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		
				);
		
		
		
		return security.build();
		
	}
	
	
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(
            List.of("http://localhost:5173")
        );

        configuration.setAllowedMethods(
            List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );

        configuration.setAllowedHeaders(
            List.of("*")
        );

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(
            "/**",
            configuration
        );

        return source;
    }
	
	@Bean
	public AuthenticationManager authenticationManager(
	        AuthenticationConfiguration configuration) throws Exception {

	    return configuration.getAuthenticationManager();
	}

}
