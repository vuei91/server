package com.nursing.home.server.config;

import com.nursing.home.server.filter.JwtAuthenticationFilter;
import com.nursing.home.server.handler.OAuth2SuccessHandler;
import com.nursing.home.server.provider.JwtProvider;
import com.nursing.home.server.service.OAuth2UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

@Configuration
@Configurable
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final DefaultOAuth2UserService oAuth2UserService;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    //AuthenticationManager Bean 등록
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //csrf disable
        http.csrf(AbstractHttpConfigurer::disable);

        //Form 로그인 방식 disable
        http.formLogin(AbstractHttpConfigurer::disable);

        //http basic 인증 방식 disable
        http.httpBasic(AbstractHttpConfigurer::disable);

        //세션 설정
        http.sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        //경로별 인가 작업
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/oauth2/**").permitAll()
                .anyRequest().authenticated());

        // OAuth2 작업
        http.oauth2Login(oauth -> oauth
                .redirectionEndpoint(endPoint -> endPoint.baseUri("/oauth2/callback/*"))
                .userInfoEndpoint(endPoint -> endPoint.userService(oAuth2UserService))
                .successHandler(oAuth2SuccessHandler)
        );

        //JWTFilter 등록 모든 필터에서 동작을 무조건적으로 실행
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // cors 설정
        http.cors((corsCustomizer -> corsCustomizer.configurationSource((request) -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
            configuration.setAllowedMethods(Collections.singletonList("*"));
            configuration.setAllowCredentials(true);
            configuration.setAllowedHeaders(Collections.singletonList("*"));
            configuration.setMaxAge(3600L);
            configuration.setExposedHeaders(Collections.singletonList("Authorization"));
            return configuration;
        })));

        return http.build();
    }
}
