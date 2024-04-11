package com.nursing.home.server.oauth2;

import com.nursing.home.server.entity.Member;
import com.nursing.home.server.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(request);
        String oAuthClientName = request.getClientRegistration().getClientName();

        Member member = null;
        String id = null;

        if(oAuthClientName.equals("kakao")) {
            id = "kakao_"+oAuth2User.getAttributes().get("id");
            member = Member.builder().username(id).type("kakao").build();
        }

        if(oAuthClientName.equals("naver")) {
            Map<String, String> responseMap = (Map<String, String>) oAuth2User.getAttributes().get("response");
            id = "naver_" + responseMap.get("id").substring(0,14);
            String email = responseMap.get("email");
            member = Member.builder().username(id).type("kakao").email(email).build();
        }

        memberRepository.save(member);
        return new CustomOAuth2User(id);
    }
}
