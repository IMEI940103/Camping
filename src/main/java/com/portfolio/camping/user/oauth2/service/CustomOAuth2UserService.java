package com.portfolio.camping.user.oauth2.service;

import com.portfolio.camping.user.entity.dto.OAuth2Attributes;
import com.portfolio.camping.user.entity.Users;
import com.portfolio.camping.user.entity.Users_Repository;
import com.portfolio.camping.user.entity.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final Users_Repository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();


        //네이버 - response 구글 - sub

        OAuth2Attributes attributes = OAuth2Attributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Users users = saveOrUpdate(attributes);

        httpSession.setAttribute("user", new SessionUser(users));

        System.out.println(attributes.getAttributes());

        return new DefaultOAuth2User(
                Collections.singleton(
                        new SimpleGrantedAuthority(users.getRoleType())),
                            attributes.getAttributes(),
                            attributes.getNameAttributeKey()
        );

    }

    private Users saveOrUpdate(OAuth2Attributes attributes){
        System.out.println();
        System.out.println(attributes.getProviderType());
        System.out.println();
        Users users = userRepository.findByUserEmailAndProviderType(attributes.getUserEmail(), attributes.getProviderType())
                .map(entity -> entity.update(attributes.getUserName(), attributes.getUserPhone()))
                .orElse(attributes.toEntity()); // orElse() Optional클래스 사용시 지정했던 객체를 받아서 그대로 return 한다.
        return userRepository.save(users);
    }


}


