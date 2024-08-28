package org.example.virtualfittingshop.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

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
                           corsConfiguration.setAllowCredentials(true);
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