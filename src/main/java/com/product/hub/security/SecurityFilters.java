package com.product.hub.security;

import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableMethodSecurity(jsr250Enabled = true)

public class SecurityFilters {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) {
		
		
		security.
		csrf(csrf -> csrf.disable()).  cors(cors -> cors.configurationSource(corsConfigurationSource()))

		
		.authorizeHttpRequests(auth->
		 auth

         .requestMatchers("/api-auth/login", "/api-auth/login/**")
         .permitAll().		requestMatchers("/api-user/register").permitAll()
         
         .requestMatchers("/api-product/view-all","api-product/view/**").hasAnyRole("ADMIN","USER")
         .requestMatchers("/api-product/add","api-product/delete/**","api-product/update/**").hasRole("ADMIN")

         .requestMatchers(
                 "/swagger-ui/**",
                 "/v3/api-docs/**",
                 "/swagger-ui.html",
                 "/api-auth/login",
                 "/api-auth/register"
             ).permitAll()
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
        	    List.of(
        	        "http://localhost:5173",
        	        "http://localhost:8080"
        	    )
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
