package com.nursing.home.server.handler;

import com.nursing.home.server.dto.CustomOAuth2User;
import com.nursing.home.server.dto.CustomUserDetails;
import com.nursing.home.server.provider.JwtProvider;
import io.jsonwebtoken.Jwt;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtProvider jwtProvider;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User user = (CustomOAuth2User) authentication.getPrincipal();
        String token = jwtProvider.create(user.getName());
        response.sendRedirect("http://localhost:3000/oauth2/"+token);
    }
}
