package com.portfolio.camping.user.entity.dto;

import com.portfolio.camping.user.entity.ProviderType;
import com.portfolio.camping.user.entity.RoleType;
import com.portfolio.camping.user.entity.Users;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuth2Attributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String user_name;
    private String user_email;
    private String user_phone;
    private ProviderType providerType;

    @Builder
    public OAuth2Attributes(Map<String,Object> attributes,String nameAttributeKey,String user_name,String user_email,String user_phone,ProviderType providerType){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.providerType = providerType;
    }

    public static OAuth2Attributes of(String registrationId,String userNameAttributeName, Map<String,Object> attributes){
        System.out.println("");
        System.out.println("");
        System.out.println(registrationId);
        System.out.println("");
        System.out.println("");
        if(registrationId.equals("google")){ return ofGoogle(userNameAttributeName,attributes);}
        else {return ofNaver(userNameAttributeName,attributes);}
    }

    private static OAuth2Attributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
        return OAuth2Attributes.builder()
                .user_name((String)attributes.get("name"))
                .user_email((String)attributes.get("email"))
                .user_phone((String)attributes.get("phone"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .providerType(ProviderType.GOOGLE)
                .build();
    }

    private static  OAuth2Attributes ofNaver(String userNameAttributeName, Map<String, Object> attributes){
        return OAuth2Attributes.builder()
                .user_name((String)attributes.get("name"))
                .user_email((String)attributes.get("email"))
                .user_phone((String)attributes.get("phone"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .providerType(ProviderType.NAVER)
                .build();
    }

    public Users toEntity(){
        return Users.builder()
                .user_name(user_name)
                .user_email(user_email)
                .user_phone(user_phone)
                .roleType(RoleType.USER)
                .providerType(providerType)
                .build();
    }

}
