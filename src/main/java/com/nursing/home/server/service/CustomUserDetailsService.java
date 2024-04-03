package com.nursing.home.server.service;

import com.nursing.home.server.dto.CustomUserDetails;
import com.nursing.home.server.entity.Member;
import com.nursing.home.server.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(username);
        if(member != null) {
            return new CustomUserDetails(member);
        }
        return null;
    }
}
