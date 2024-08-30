package org.example.virtualfittingshop.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return
                httpSecurity
                        //cors
                        .cors(cors -> cors.configurationSource(request -> {
                           var corsConfiguration =  new CorsConfiguration();
                            corsConfiguration.setAllowedOriginPatterns(List.of("http://localhost:*"));  // 모든 도메인 허용
                            corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));  // 모든 HTTP 메서드 허용
                            corsConfiguration.setAllowedHeaders(List.of("*"));  // 모든 헤더 허용
                            corsConfiguration.setAllowCredentials(true);  // 자격 증명(쿠키, Authorization 헤더 등) 허용

                            return corsConfiguration;
                        }))
                        .csrf((auth) -> auth.disable())
                        .authorizeHttpRequests(auth -> auth
                                        .requestMatchers("/**").permitAll()
                        ).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // 비밀번호 암호화를 위한 BCrypt 인코더 사용
    }
}